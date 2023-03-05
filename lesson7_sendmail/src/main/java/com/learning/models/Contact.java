package com.learning.models;

public class Contact {
	private String fullname;
	private String email;
	private String content;
	private String subject;
	private String phone;

	public Contact() {
	}

	public Contact(String fullname, String email, String content, String subject, String phone) {
		this.fullname = fullname;
		this.email = email;
		this.content = content;
		this.subject = subject;
		this.phone = phone;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
