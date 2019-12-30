package com.traveler.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.traveler.util.AdminPagination;
import com.traveler.util.Pagination;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberPage {
	
	@XmlElementWrapper(name="members")
	@XmlElement(name="member")
	List<Member> members;
	
	Pagination paging;
	AdminPagination pagination;

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Pagination getPaging() {
		return paging;
	}

	public void setPaging(Pagination paging) {
		this.paging = paging;
	}

	public AdminPagination getPagination() {
		return pagination;
	}

	public void setPagination(AdminPagination pagination) {
		this.pagination = pagination;
	}
	
	


	
	
}
