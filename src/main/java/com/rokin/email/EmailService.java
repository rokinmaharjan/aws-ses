package com.rokin.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.rokin.ses.SesService;

@Service
public class EmailService {

	@Autowired
	AmazonSimpleEmailService ses;

	public void sendEmail(EmailDto emailDto) throws Exception {
		SesService.sendEmail(ses, emailDto);
	}
}
