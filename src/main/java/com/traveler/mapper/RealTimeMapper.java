package com.traveler.mapper;

import java.util.List;

import com.traveler.model.RealTime;
import com.traveler.util.Pagination;

public interface RealTimeMapper {
	int selectCount();
	List<RealTime> selectAll();
	RealTime selectByNumber(int number);
	List<RealTime> selectPage(Pagination paging);
	
	int insert(RealTime realTime);
	
	int deleteByNumber(int number);
	int deleteAll();
}
