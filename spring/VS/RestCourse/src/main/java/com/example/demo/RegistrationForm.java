package com.example.demo;

import org.springframework.security.crypto.password.PasswordEncoder;


public class RegistrationForm {
	private String username;
	private String password;
	private String fullname;
	private String phone;
	
	public User toUser(PasswordEncoder passwordEncoder) {
		return new User(username, passwordEncoder.encode(password), fullname, phone);
	}
	
	public RegistrationForm(String username, String password, String fullname, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
	}
	
	public RegistrationForm() {
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
