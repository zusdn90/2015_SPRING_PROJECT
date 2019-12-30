package com.traveler.service;

import com.traveler.dao.RealTimeDao;

public class RealTimeUnRegisterService {
		RealTimeDao realTimeDao;

		public void setRealTimeDao(RealTimeDao realTimeDao) {
			this.realTimeDao = realTimeDao;
		}
		
		public int unRegist(int number)
		{
			realTimeDao.deleteByNumber(number);
			
			return number;
		}
		
}
