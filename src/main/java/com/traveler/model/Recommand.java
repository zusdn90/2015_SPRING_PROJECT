package com.traveler.model;

import java.util.List;



public class Recommand {
	private int listNo;
	private	String title;
	private String area;
	private String name;
	private String content;
	private String picture;
	List<Comment> comments;
	
	
	public void setCommentList(List<Comment> comments){
		this.comments=comments;
	}
	
	
	public List<Comment> getComments() {
		return comments;
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
	
}
