package com.traveler.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RealTime {
	private int number;
	private String content;
	private String id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date real_date;
	
	public String getId() {
		return id;
	}

	public Date getReal_date() {
		return real_date;
	}

	public void setReal_date(Date real_date) {
		this.real_date = real_date;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

}
