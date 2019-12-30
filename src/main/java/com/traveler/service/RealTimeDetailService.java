package com.traveler.service;

import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.RealTimeDao;
import com.traveler.model.RealTime;

public class RealTimeDetailService {
	RealTimeDao realTimeDao;

	public void setRealTimeDao(RealTimeDao realTimeDao) {
		this.realTimeDao = realTimeDao;
	}
	
	@Transactional
	public RealTime realTimeDetail(int number) {
		
		RealTime realTime = realTimeDao.selectByNumber(number);
		
		return realTime;
	}

}
