package com.tghr.aws.s3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tghr.aws.s3.dto.FileDto;
import com.tghr.aws.s3.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FileService {
	
	@Autowired
    private FileRepository fileRepository;

    public void saveFileInfo(FileDto fileDto) {
    	fileRepository.save(fileDto.toEntity());
    }   
}
