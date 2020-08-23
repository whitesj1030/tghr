package com.tghr.aws.s3.reposigory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tghr.aws.s3.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
