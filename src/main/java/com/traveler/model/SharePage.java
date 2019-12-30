package com.traveler.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.traveler.util.Pagination;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class SharePage {
	
	@XmlElementWrapper(name="shares")
	@XmlElement(name="share")
	List<Share> shares;
	
	Pagination paging;
	
	public List<Share> getShares() {
		return shares;
	}

	public Pagination getPaging() {
		return paging;
	}

	public void setPaging(Pagination paging) {
		this.paging = paging;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	

}
