package com.tghr.aws.s3.service;

import org.springframework.stereotype.Service;

import com.tghr.aws.s3.dto.FileDto;
import com.tghr.aws.s3.reposigory.FileRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FileService {
    private FileRepository fileRepository;

    public void savePost(FileDto fileDto) {
    	fileRepository.save(fileDto.toEntity());
    }
}
