package com.rokin.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emails")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/email")
	public String sendEmail(@RequestBody EmailDto emailDto) {
		try {
			emailService.sendEmail(emailDto);
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		return "Email sent to " + emailDto.getTo() + " successfully";
	}

}
