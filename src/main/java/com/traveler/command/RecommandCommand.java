package com.traveler.command;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.traveler.model.Recommand;

@JsonIgnoreProperties(value = "recommand")
public class RecommandCommand {
	private int listNo;
	private	String title;
	private String area;
	private String name;
	private String content;
	private String picture;
	
	private Map<String, Object> errorMessage;
	
	public RecommandCommand() {
		errorMessage = new HashMap<>();
	}
	
	public Map<String, Object> getErrorMessage() {
		return errorMessage;
	}
	
	public void validate() {
		/*
		 * name validation
		 */
		
		/*
		 * coutryCode validation
		 */
		
		/*
		 * district validation
		 */
		
		/*
		 * population validation
		 */
		
	}
	
	public boolean isValid() {
		
		if (errorMessage.size() > 0)
			return false;
		
		return true;
	}
	
	public Recommand getRecommand() {
		Recommand r = new Recommand();
		r.setListNo(listNo);
		r.setArea(area);
		r.setContent(content);
		r.setName(name);
		r.setPicture(picture);
		r.setTitle(title);
		
		return r;
	}

	public int getListNo() {
		return listNo;
	}

	public void setListNo(int listNo) {
		this.listNo = listNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setErrorMessage(Map<String, Object> errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
}
