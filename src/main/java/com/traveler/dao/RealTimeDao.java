package com.traveler.dao;

import java.util.List;

import com.traveler.mapper.RealTimeMapper;
import com.traveler.model.RealTime;
import com.traveler.util.Pagination;

public class RealTimeDao {
	RealTimeMapper realTimeMapper;

	public void setRealTimeMapper(RealTimeMapper realTimeMapper) {
		this.realTimeMapper = realTimeMapper;
	}
	
	public int selectCount()
	{
		return realTimeMapper.selectCount();
	}
	
	public List<RealTime> selectAll()
	{
		return realTimeMapper.selectAll();
	}

	public RealTime selectByNumber(int number) {
		return realTimeMapper.selectByNumber(number);
	}
	public List<RealTime> selectPage(Pagination paging)
	{
		return realTimeMapper.selectPage(paging);
	}
	
	public String insert(RealTime realTime)
	{
		int rtn = realTimeMapper.insert(realTime);
		
		return realTime.getId();
	}
	
	public int deleteByNumber(int number) {
		return realTimeMapper.deleteByNumber(number);
	}
	
	public int deleteAll() {
		return realTimeMapper.deleteAll();
	}
	
}
