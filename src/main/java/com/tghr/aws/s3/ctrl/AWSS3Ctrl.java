package com.tghr.aws.s3.ctrl;

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

import com.tghr.aws.s3.dto.FileDto;
import com.tghr.aws.s3.service.AWSS3Service;
import com.tghr.aws.s3.service.FileService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value= "/s3")
public class AWSS3Ctrl {
	
	private AWSS3Service s3service;
    private FileService fileService;

    /**
     * 파일 업로드 
     * @param  
     * @param multipartFile
     * @return
     */
	@PostMapping(value= "/upload")
	public ResponseEntity<String> uploadFile(@RequestPart(value= "file") final MultipartFile multipartFile) {
		String uniqueFileName = s3service.uploadFile(multipartFile);
		FileDto fileDto = new FileDto ();
		fileDto.setTitle("SM3");
		fileDto.setFilePath(uniqueFileName);
        fileService.savePost(fileDto);
        
		final String response = "[" + multipartFile.getOriginalFilename() + "] uploaded successfully.";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value= "/download")
	public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam(value= "fileName") final String keyName) {
		final byte[] data = s3service.downloadFile(keyName);
		final ByteArrayResource resource = new ByteArrayResource(data);
		return ResponseEntity
				.ok()
				.contentLength(data.length)
				.header("Content-type", "application/octet-stream")
				.header("Content-disposition", "attachment; filename=\"" + keyName + "\"")
				.body(resource);
	}
}
