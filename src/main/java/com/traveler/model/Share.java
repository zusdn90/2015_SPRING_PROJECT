package com.traveler.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Share {
	private int boardNum;
	private String title;
	private String term;
	private int number;
	private String picture;
	private String map;
	private String content;
	private int transCost;
	private int stayCost;
	private int eatCost;
	private int totalCost;
	private String id;
	private String writer;
	private String memberPicture;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date	birthday;	
	private String tel;
	
	public String getMemberPicture() {
		return memberPicture;
	}
	public void setMemberPicture(String memberPicture) {
		this.memberPicture = memberPicture;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	List<Comment> comments;
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTransCost() {
		return transCost;
	}
	public void setTransCost(int transCost) {
		this.transCost = transCost;
	}
	public int getStayCost() {
		return stayCost;
	}
	public void setStayCost(int stayCost) {
		this.stayCost = stayCost;
	}
	public int getEatCost() {
		return eatCost;
	}
	public void setEatCost(int eatCost) {
		this.eatCost = eatCost;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
}




