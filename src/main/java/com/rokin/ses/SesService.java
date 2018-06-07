package com.rokin.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.rokin.email.EmailDto;

public class SesService {
	
	public static void sendEmail(AmazonSimpleEmailService ses, EmailDto emailDto) {
		try {
			SendEmailRequest request = new SendEmailRequest()
			          .withDestination(
			              new Destination().withToAddresses(emailDto.getTo()))
			          .withMessage(new Message()
			              .withBody(new Body()
			                  .withHtml(new Content()
			                      .withCharset("UTF-8").withData(emailDto.getBody())))
			              .withSubject(new Content()
			                  .withCharset("UTF-8").withData(emailDto.getSubject())))
			          .withSource(emailDto.getFrom());
			ses.sendEmail(request);
		} catch (Exception e) {
			System.out.println("The email was not sent. Error message: " 
			          + e.getMessage());
			throw e;
		}
	}

}
