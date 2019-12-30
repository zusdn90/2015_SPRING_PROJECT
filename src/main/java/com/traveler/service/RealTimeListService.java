package com.traveler.service;

import java.util.List;

import com.traveler.dao.RealTimeDao;
import com.traveler.model.RealTime;
import com.traveler.model.RealTimeList;

public class RealTimeListService {
	RealTimeDao realTimeDao;

	public void setRealTimeDao(RealTimeDao realTimeDao) {
		this.realTimeDao = realTimeDao;
	}
	
	public RealTimeList getList()
	{
		List<RealTime> realTimes = realTimeDao.selectAll();
		RealTimeList rtn = new RealTimeList();
		rtn.setRealTimes(realTimes);
		return rtn;
	}
}
