package com.traveler.mapper;

import java.util.List;

import com.traveler.model.Share;
import com.traveler.util.Pagination;

public interface ShareMapper {

		int selectCount();
		List<Share> selectAll();
		Share selectByboardNum(int boardNum);
		List<Share> selectPage(Pagination paging);
		
		int insert(Share share);
		int update(Share share);
		
		int deleteByboardNum(int boardNum);
		
		int deleteAll();
}
