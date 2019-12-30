package com.traveler.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.traveler.exception.PasswordNotMatchingException;

public class Member {
	
	private int num;
	private String 	id;
	private String 	password;
	private String 	name;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date 	register_date;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date	birthday;
	private String 	tel;
	private String 	address;
	private Integer addressNum;
	private String  memberPicture;
	
	
	public String getMemberPicture() {
		return memberPicture;
	}
	public void setMemberPicture(String memberPicture) {
		this.memberPicture = memberPicture;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAddressNum() {
		return addressNum;
	}
	public void setAddressNum(Integer addressNum) {
		this.addressNum = addressNum;
	}
	
}
