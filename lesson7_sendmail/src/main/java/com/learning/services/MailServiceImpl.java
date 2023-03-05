package com.learning.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void send(String from, String to, String subject, String content) throws MessagingException{
//		MIME = Multipurpose Internet Mail Extensions
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setSentDate(new Date());
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(content, true);
		sender.send(mimeMessage);
	}

	@Override
	public void sentWithFile(String from, String to, String subject, String content, MultipartFile multipartFile)
			throws MessagingException {
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setSentDate(new Date());
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(content, true);

		
//		Build mail body
//		bao gom 2 phan: text content / file content (attachment)
		Multipart multipart = new MimeMultipart(); 
		
//		text content
		BodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(content, "text/html");
		
		multipart.addBodyPart(bodyPart);
		
		// attachment
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setFileName(multipartFile.getOriginalFilename());
		FileDataSource fileDataSource = new FileDataSource(convertToFile(multipartFile));
		mimeBodyPart.setDataHandler(new DataHandler(fileDataSource));
		multipart.addBodyPart(mimeBodyPart);
		
		mimeMessage.setContent(multipart);
		
		sender.send(mimeMessage);
	}
	
	private File convertToFile(MultipartFile multipartFile) {
		try {
			File file = new File(multipartFile.getOriginalFilename()); 
			file.createNewFile(); // tạo ra file mới vs tên = file cũ
			// ghi file ng ta up lên vào file mới tạo			
			FileOutputStream fileOutputStream = new FileOutputStream(file); 
			fileOutputStream.write(multipartFile.getBytes());
			fileOutputStream.close();
			return file;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void sentWithFiles(String from, String to, String subject, String content, MultipartFile[] multipartFiles)
			throws MessagingException {
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setSentDate(new Date());
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(content, true);

		
//		Build mail body
//		bao gom 2 phan: text content / file content (attachment)
		Multipart multipart = new MimeMultipart(); 
		
//		text content
		BodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(content, "text/html");
		
		multipart.addBodyPart(bodyPart);
		
		// attachment files
		for(MultipartFile file : multipartFiles) {
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setFileName(file.getOriginalFilename());
			FileDataSource fileDataSource = new FileDataSource(convertToFile(file));
			mimeBodyPart.setDataHandler(new DataHandler(fileDataSource));
			multipart.addBodyPart(mimeBodyPart);
			
		}
		mimeMessage.setContent(multipart);
		
		sender.send(mimeMessage);
		
	}

}
