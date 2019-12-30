package com.traveler.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.RecommandDao;
import com.traveler.model.Recommand;
import com.traveler.model.RecommandPage;
import com.traveler.util.Pagination;

public class RecommandPageService {
	static RecommandDao recommandDao;
	
	public void setRecommandDao(RecommandDao dao) {
		this.recommandDao = dao;
	}
	
	@Transactional
	public RecommandPage getPage(int pageNo) {
		
		Pagination paging = new Pagination();
		paging.setPageNo(pageNo);
		paging.setTotalItem(recommandDao.selectCount());
		List<Recommand> list =recommandDao.selectPage(paging);
		
		RecommandPage page = new RecommandPage();
		page.setPaging(paging);
		page.setRecommandLists(list);
		
		return page;
	}
	
	public int getCount(){
		int count = recommandDao.selectCount();
		return count;
	}

}
