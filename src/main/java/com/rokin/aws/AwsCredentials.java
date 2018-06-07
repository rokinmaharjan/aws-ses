package com.rokin.aws;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "aws")
@Data
public class AwsCredentials {
	private String accessKey;
	private String accessSecret;
	private String sesRegion;
}
