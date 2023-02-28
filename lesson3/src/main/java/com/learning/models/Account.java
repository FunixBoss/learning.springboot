package com.learning.models;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Account {
	private int id;
	private String username;
	private String password;
	private Boolean status;
	private String description;
	private String[] languages;
	private String gender;
	private String cert;
	private String role;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday; // show là từ thời gian -> chuỗi // submit là từ chuỗi -> thời gian

	private Address address; // dependencies

	public Account() {
		super();
	}

	public Account(String username, String password, Boolean status, String description, String[] languages) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
		this.description = description;
		this.languages = languages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", status=" + status + ", description="
				+ description + ", languages=" + Arrays.toString(languages) + "]";
	}
}
