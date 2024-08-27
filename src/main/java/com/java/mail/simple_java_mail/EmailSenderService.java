package com.java.mail.simple_java_mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,
                          String subject,
                          String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("blimanikyasa@gmail.com");//enable jika gmail
//        message.setFrom("portal.bcp@devmandiri.co.id");//enable jika non gmail
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Mail Send Successfully");
    }

    public void sendEmailWithAttachment(String toEmail,
                                        String subject,
                                        String body,
                                        String attachment) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("blimanikyasa@gmail.com");//enable jika gmail
//        mimeMessageHelper.setFrom("portal.bcp@devmandiri.co.id");//enable jika non gmail
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystemResource =
                new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
        mailSender.send(mimeMessage);
        System.out.println("Mail with attachments sent successfully");
    }
}
