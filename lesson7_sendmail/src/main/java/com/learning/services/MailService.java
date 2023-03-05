package com.learning.services;

import javax.mail.MessagingException;

import org.springframework.web.multipart.MultipartFile;

public interface MailService {

	void send(String from, String to, String subject, String content) throws MessagingException;
	void sentWithFile(String from, String to, String subject, String content, MultipartFile multipartFile) throws MessagingException;
	void sentWithFiles(String from, String to, String subject, String content, MultipartFile[] multipartFiles) throws MessagingException;

}

