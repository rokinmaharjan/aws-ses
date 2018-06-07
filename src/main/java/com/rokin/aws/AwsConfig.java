package com.rokin.aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
public class AwsConfig {

	@Autowired
	private AwsCredentials awsCredential;

	public AWSCredentials getAwsCredentials() {
		return new BasicAWSCredentials(awsCredential.getAccessKey(), awsCredential.getAccessSecret());
	}

	@Bean
	public AmazonSimpleEmailService amazonSimpleEmailService() {
		return AmazonSimpleEmailServiceClientBuilder.standard()
		          .withCredentials(new AWSStaticCredentialsProvider(getAwsCredentials()))
		          .withRegion(awsCredential.getSesRegion()).build();
	}
}
