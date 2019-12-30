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
public class RealTimePage {
	
	@XmlElementWrapper(name="realTimes")
	@XmlElement(name="realTime")
	List<RealTime> realTimes;
	
	Pagination paging;

	public List<RealTime> getRealTimes() {
		return realTimes;
	}

	public void setRealTimes(List<RealTime> realTimes) {
		this.realTimes = realTimes;
	}

	public Pagination getPaging() {
		return paging;
	}

	public void setPaging(Pagination paging) {
		this.paging = paging;
	}
}
