package com.traveler.command;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.traveler.model.Share;

@JsonIgnoreProperties(value="share")
public class ShareCommand {						//Server 측으로 데이터를 넘길때 
	private int boardNum;
	private String title;
	private String term;
	private int number;
	private String content;
	private String picture;
	private String map;
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

	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	
	private Map<String, Object> errorMessage;
	
	public ShareCommand()
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
	
	public Share getShare()
	{
		Share s = new Share();
		
		s.setBoardNum(boardNum);
		s.setId(id);
		s.setEatCost(eatCost);
		s.setStayCost(stayCost);
		s.setTransCost(transCost);
		s.setTotalCost(totalCost);
		s.setMap(map);
		s.setNumber(number);
		s.setPicture(picture);
		s.setTerm(term);
		s.setContent(content);
		s.setTitle(title);
		s.setWriter(writer);
		s.setMemberPicture(memberPicture);
		s.setTel(tel);
		s.setBirthday(birthday);
		
		return s;
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
