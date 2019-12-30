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
public class RecommandPage {
	
	@XmlElementWrapper(name="recommandList")
	@XmlElement(name="recommand")
	List<Recommand> recommandLists;
	
	Pagination paging;

	public List<Recommand> getRecommandLists() {
		return recommandLists;
	}

	public void setRecommandLists(List<Recommand> recommandLists) {
		this.recommandLists = recommandLists;
	}

	public Pagination getPaging() {
		return paging;
	}

	public void setPaging(Pagination paging) {
		this.paging = paging;
	}
	
}
