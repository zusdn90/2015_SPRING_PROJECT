package com.traveler.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class RealTimeList {
	@XmlElementWrapper(name="realTimes")
	@XmlElement(name="realTime")
	
	List<RealTime> realTimes;

	public List<RealTime> getRealTimes() {
		return realTimes;
	}

	public void setRealTimes(List<RealTime> realTimes) {
		this.realTimes = realTimes;
	}
}
