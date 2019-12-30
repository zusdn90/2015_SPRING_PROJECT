package com.traveler.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.RealTimeDao;
import com.traveler.model.RealTime;

public class RealTimeRegisterService {
	static Log log = LogFactory.getLog(RealTimeRegisterService.class);
	
	RealTimeDao realTimeDao;
	
	public void setRealTimeDao(RealTimeDao dao)
	{
		this.realTimeDao = dao;
	}
	
	@Transactional
	public String regist(RealTime realTime) throws Exception
	{
		String id = null;
		
		try{
			id = realTimeDao.insert(realTime);
		}catch(DataIntegrityViolationException e)
		{
			log.error(e);
			throw new Exception();
		}
		return id;
	}
	
}
