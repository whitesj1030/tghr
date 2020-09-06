package com.tghr.aws.s3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * 
 * @author white
 *
 */
@Configuration
public class AWSS3Config {

	@Value("${aws.access_key_id}")
	private String accessKeyId;

	@Value("${aws.secret_access_key}")
	private String secretAccessKey;
	
	@Value("${aws.s3.region}")
	private String region;

	@Bean
	public AmazonS3 getAmazonS3Cient() {
		final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
		return AmazonS3ClientBuilder
				.standard()
				//.withRegion(Regions.fromName(region))
				.withRegion(this.region)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
				.build();
	}
	
	
}
