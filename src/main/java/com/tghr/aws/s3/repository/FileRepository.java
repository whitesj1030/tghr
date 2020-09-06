package com.tghr.aws.s3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tghr.aws.s3.model.File;

public interface FileRepository extends JpaRepository<File, Long> {
}
