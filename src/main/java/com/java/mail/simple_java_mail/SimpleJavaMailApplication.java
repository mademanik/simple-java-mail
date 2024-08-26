package com.java.mail.simple_java_mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SimpleJavaMailApplication {

	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(SimpleJavaMailApplication.class, args);
	}

//	open if want send simple email without attachmentss
	@EventListener(ApplicationReadyEvent.class)
    public void sendMail() {
        senderService.sendEmail("manik.yasa@gmail.com",
                "This is subject demo", "This is body demo");
    }

	//open if want send simple email with attachmentss
//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMailWithAttachment() throws MessagingException {
//		senderService.sendEmailWithAttachment("manik.yasa@gmail.com",
//				"This is subject demo with attachment",
//				"This is body demo with attachment",
//				"/home/itopr/upload.pdf");
//	}

}
