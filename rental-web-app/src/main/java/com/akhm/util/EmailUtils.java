package com.akhm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;


	public String sendEmail(String from, String to, String subject, String body) {
		try {

			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(from);
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(body);

			javaMailSender.send(simpleMailMessage);

			return "mailsentsuccessfully";

		} catch (Exception e) {

			return "error while sending email";
		}
		
	}

}
