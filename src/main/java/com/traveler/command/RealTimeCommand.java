package com.traveler.command;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.traveler.model.RealTime;


@JsonIgnoreProperties(value="realTime")
public class RealTimeCommand {
	private int number;
	private String content;
	private String id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date real_date;
	public Date getReal_date() {
		return real_date;
	}
	public void setReal_date(Date real_date) {
		this.real_date = real_date;
	}

	private Map<String, Object> errorMessage;
	
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public RealTimeCommand()
	{
		errorMessage = new HashMap<>();
	}
	
	public Map<String, Object> getErrorMessage()
	{
		return errorMessage;
	}
	
	public void validate()							//유효성 검사
	{
		/*
		 *  name validation
		 */
		/*
		 *  countryCode validation
		 */
		/*
		 *  district validation
		 */
		/*
		 *  population validation
		 */
	}
	public boolean isValid()
	{
		if(errorMessage.size()>0)
			return false;
		
		return true;
	}
	
	public RealTime getRealTime()
	{
		RealTime rt = new RealTime();
		
		rt.setContent(content);
		rt.setNumber(number);
		rt.setReal_date(real_date);
		rt.setId(id);
		
		return rt;
	}
}
