package com.traveler.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberList {
	
	@XmlElementWrapper(name="members")
	@XmlElement(name="member")

	List<Member> members;
	
	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
}
