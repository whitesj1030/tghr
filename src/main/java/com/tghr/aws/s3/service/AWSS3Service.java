package com.tghr.aws.s3.service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.tghr.aws.s3.dto.FileDto;
import com.tghr.comm.exception.ApplicationException;
import com.tghr.comm.util.TghrFileUtil;

@Service
public class AWSS3Service {

	private static final Logger logger = LoggerFactory.getLogger(AWSS3Service.class);
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private AmazonS3 amazonS3;
	
	@Value("${aws.s3.bucket}")
	private String bucketName;	

	@Autowired
	private TghrFileUtil fileutil;
	
	/**
	 * 여러게 파일 업로드
	 * @param multipartFiles
	 * @return
	 */
	public void uploadFiles(final MultipartFile[] multipartFiles, String carId) {
		List<MultipartFile> filelist = Arrays.asList(multipartFiles);        
		for (MultipartFile file : filelist) {
			this.uploadFile(file, carId);
		}
	}

	// @Async annotation ensures that the method is executed in a different background thread 
	// but not consume the main thread.
	@Async
	public String uploadFile(final MultipartFile multipartFile, String carId) {
		String uniqueFileName="";
		try {
			final File file = fileutil.convertMultiPartFileToFile(multipartFile);	
			PutObjectRequest putObjectRequest = fileutil.uploadFileToS3Bucket(file, carId);
			amazonS3.putObject(putObjectRequest);
			uniqueFileName = putObjectRequest.getFile().getName();			
			URI fileURI = putObjectRequest.getFile().toURI();
			logger.info("File upload is completed.");
			file.delete();	 // To remove the file locally created in the project folder.			
			FileDto fileDto = new FileDto();
			fileDto.setTitle("SM3");
			fileDto.setCarId(Long.parseLong(carId));
			fileDto.setFileURL(fileURI.getPath());
			fileService.saveFileInfo(fileDto);
			
		} catch (final AmazonServiceException ex) {
			logger.info("File upload is failed.");
			logger.error("Error= {} while uploading file.", ex.getMessage());
			throw new ApplicationException("File upload is failed.");
		}
		return uniqueFileName;
	}
	

    // @Async annotation ensures that the method is executed in a different background thread 
	// but not consume the main thread.
	@Async
	public byte[] downloadFile(final String keyName) {
		byte[] content = null;
		logger.info("Downloading an object with key= " + keyName);
		final S3Object s3Object = amazonS3.getObject(bucketName, keyName);
		final S3ObjectInputStream stream = s3Object.getObjectContent();
		try {
			content = IOUtils.toByteArray(stream);
			logger.info("File downloaded successfully.");
			s3Object.close();
		} catch(final IOException e) {
			logger.info("IO Error Message= " + e.getMessage());	
			throw new ApplicationException("File download is failed.");
		}
		return content;
	}
	
	/**
	 * S3 에서 File URI Get : From S3
	 * @param carId
	 * @return
	 */
	public List<String> getCarImageList(final String carId){
		 List<String> fileURIList = new ArrayList<String>();
		try {
			
			fileURIList = fileutil.getCarImagesList(amazonS3, fileutil.getFilePrefix(carId) );
		} catch (Exception e) {
			logger.info("IO Error Message= " + e.getMessage());
			throw new ApplicationException("File list down is failed.");
		}
		return fileURIList;
	}
}
