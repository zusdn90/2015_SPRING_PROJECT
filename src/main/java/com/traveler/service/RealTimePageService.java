package com.traveler.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.RealTimeDao;
import com.traveler.model.RealTime;
import com.traveler.model.RealTimePage;
import com.traveler.util.Pagination;

public class RealTimePageService {
	RealTimeDao realTimeDao;

	public void setRealTimeDao(RealTimeDao realTimeDao) {
		this.realTimeDao = realTimeDao;
	}
	
	@Transactional
	public RealTimePage getPage(int pageNo)
	{
		Pagination paging = new Pagination();
		paging.setPageNo(pageNo);
		paging.setTotalItem(realTimeDao.selectCount());
		List<RealTime> list = realTimeDao.selectPage(paging);
		
		RealTimePage page = new RealTimePage();
		page.setPaging(paging);
		page.setRealTimes(list);
		return page;
	}
	
}
