package com.traveler.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecommandList {
	
	@XmlElementWrapper(name="recommandLists")
	@XmlElement(name="recommand")
	List<Recommand> recommandLists;

	public List<Recommand> getRecommandLists() {
		return recommandLists;
	}

	public void setRecommandLists(List<Recommand> recommandList) {
		this.recommandLists = recommandList;
	}
	

}
