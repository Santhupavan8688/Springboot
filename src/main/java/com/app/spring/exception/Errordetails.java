package com.app.spring.exception;

import java.util.Date;

public class Errordetails {
	private Date date;
	private String message;
	private String details;
	public Errordetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Errordetails(Date date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	

}
