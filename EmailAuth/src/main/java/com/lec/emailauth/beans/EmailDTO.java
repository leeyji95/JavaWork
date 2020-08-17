package com.lec.emailauth.beans;

public class EmailDTO {
	private int email_uid;
	private String email;
	private String user_key;
	public EmailDTO() {
		super();
	}
	public EmailDTO(int email_uid, String email, String user_key) {
		super();
		this.email_uid = email_uid;
		this.email = email;
		this.user_key = user_key;
	}
	public int getEmail_uid() {
		return email_uid;
	}
	public void setEmail_uid(int email_uid) {
		this.email_uid = email_uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_key() {
		return user_key;
	}
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	
}
