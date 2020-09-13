package com.tghr.aws.s3.ctrl;

import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tghr.aws.s3.service.AWSS3Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(value = "[파일] 파일  API", tags = {"[파일]  파일 서버 API (CRUD)"})
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/s3")
public class AWSS3Controller {

	private AWSS3Service s3service;

	@ApiOperation(value = "파일 업로드", notes = "단일 파일 업로드")
	@PostMapping(value = "/upload")
	public ResponseEntity<String> uploadFile(@RequestPart(value = "file") final MultipartFile multipartFile, @RequestParam(value = "carId") final String carId) {
		try {
			s3service.uploadFile(multipartFile, carId);
		} catch (Exception e) {
			String responseNG = "File Upload Error : "+ e.getMessage();
			return new ResponseEntity<>(responseNG, HttpStatus.BAD_REQUEST);
		}
		String responseOK = "[" + multipartFile.getOriginalFilename() + "] uploaded successfully.";
		return new ResponseEntity<>(responseOK, HttpStatus.OK);
	}
	
	@ApiOperation(value = "여러개 파일 업로드", notes = "복수 파일 업로드")
	@PostMapping(value = "/uploadFiles")
    public ResponseEntity<String> uploadFiles(@RequestParam("files") MultipartFile[] files,  @RequestParam(value = "carId") final String carId) {
		try {
			s3service.uploadFiles(files, carId);
		} catch (Exception e) {
			String responseNG = "File Upload Error : "+ e.getMessage();
			return new ResponseEntity<>(responseNG, HttpStatus.BAD_REQUEST);
		}
		final String responseOK = "[Multiple files] uploaded successfully.";
		return new ResponseEntity<>(responseOK, HttpStatus.OK);
    }

	@ApiOperation(value = "다운로드", notes = "단일 파일 다운로드")
	@GetMapping(value = "/download")
	public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam(value = "fileName") final String keyName) {
		final byte[] data = s3service.downloadFile(keyName);
		final ByteArrayResource resource = new ByteArrayResource(data);
		return ResponseEntity.ok().contentLength(data.length).header("Content-type", "application/octet-stream")
				.header("Content-disposition", "attachment; filename=\"" + keyName + "\"").body(resource);
	}
	
	@ApiOperation(value = "여러개 파일 URL download", notes = "복수 파일 URL download")
	@GetMapping(value = "/imageList")
	public ResponseEntity<Object> imageList(@RequestParam(value = "carId") final String carid) {
		final List<String> imageUrlList = s3service.getCarImageList(carid);
		return ResponseEntity.status(HttpStatus.OK).body(imageUrlList);		
	}
}
