package com.tghr.comm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.tghr.comm.consts.AppConstants;
import com.tghr.comm.exception.ApplicationException;

@Component
public class TghrFileUtil {
	
	@Value("${aws.s3.bucket}")
	private String bucketName;
	
	private static final Logger logger = LoggerFactory.getLogger(TghrFileUtil.class);
	
	public String getFilePrefix(String carId) {
		return AppConstants.FILE_PREFIX+carId + AppConstants.FILE_SURFFIX;
	}
	
	
	public File convertMultiPartFileToFile(final MultipartFile multipartFile) {
		final File file = new File(multipartFile.getOriginalFilename());
		try (final FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(multipartFile.getBytes());
		} catch (final IOException ex) {
			logger.error("Error converting the multi-part file to file= ", ex.getMessage());
			throw new ApplicationException("Error converting the multi-part file to file");
		}
		return file;
	}

	/**
	 * 파일명 생성 및 PutObject 생성
	 * @param file
	 * @param carId
	 * @return
	 */
	public PutObjectRequest uploadFileToS3Bucket(final File file, String carId) {
		final String uniqueFileName = this.getFilePrefix(carId) + LocalDateTime.now() + "_" + file.getName();
		logger.info("Uploading file with name= " + uniqueFileName);
		return new PutObjectRequest(bucketName, uniqueFileName, file);			
	}
	
    public List<String> getCarImagesList(AmazonS3 s3Client, String prefix) throws Exception {
        
        List<String> carImageList = new ArrayList<String>();
        
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        listObjectsRequest.setBucketName(bucketName);
        listObjectsRequest.setPrefix(prefix);
        
        ObjectListing objects = s3Client.listObjects(listObjectsRequest);
        
        do {
            objects = s3Client.listObjects(listObjectsRequest);
            
            for(S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
                logger.info("keyname : " + objectSummary.getKey());             
                carImageList.add(objectSummary.getKey());
                
                // Set the presigned URL to expire after one hour.
                java.util.Date expiration = new java.util.Date();
                long expTimeMillis = expiration.getTime();
                expTimeMillis += 1000 * 60 * 60;
                expiration.setTime(expTimeMillis);
                
                GeneratePresignedUrlRequest generatePresignedUrlRequest =
                        new GeneratePresignedUrlRequest(bucketName, objectSummary.getKey())
                                .withMethod(HttpMethod.GET)
                                .withExpiration(expiration);
                URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
                System.out.println("Pre-Signed URL: " + url.toString());
            }
            
            listObjectsRequest.setMarker(objects.getNextMarker());
        } while(objects.isTruncated());
        
        return carImageList;
    }

}
