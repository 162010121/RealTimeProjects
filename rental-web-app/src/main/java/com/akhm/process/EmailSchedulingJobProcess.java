package com.akhm.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import com.akhm.util.EmailUtils;

import lombok.extern.slf4j.Slf4j;

@ComponentScan
@Slf4j
@EnableScheduling
public class EmailSchedulingJobProcess {
	
	@Autowired
	private EmailUtils emailUtils;
	@Scheduled(cron="0 0/5 * * * ?")
	public void sendEmailMessage()
	{
		log.info("in EmailSchedulingJobProcess...sendEmailMessage strted");
		try {
			
			log.info("in EmailSchedulingJobProcess...sendEmailMessage details are stored");
			emailUtils.sendEmail("praveensonu1999@gmail.com","ppustela@gmail.com","Hi to Wish","How are You");
			
		} catch (Exception e) {
			
			log.error("erro while sending mail");
		}
	}
	
	
}
