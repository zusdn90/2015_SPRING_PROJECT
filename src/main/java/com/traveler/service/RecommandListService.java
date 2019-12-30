package com.traveler.service;

import java.util.List;

import com.traveler.dao.RecommandDao;
import com.traveler.model.Recommand;
import com.traveler.model.RecommandList;

public class RecommandListService {
	RecommandDao recommandDao;
	
	public void setRecommandDao(RecommandDao recommandDao) {
		this.recommandDao = recommandDao;
	}
	
	public RecommandList getList() {
		List<Recommand> recommandLists = recommandDao.selectAllRecommand();
		RecommandList rtn = new RecommandList();
		rtn.setRecommandLists(recommandLists);
		
		return rtn;
	}

}
