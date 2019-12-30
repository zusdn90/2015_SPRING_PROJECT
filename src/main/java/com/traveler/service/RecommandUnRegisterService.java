package com.traveler.service;


import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.RecommandDao;
import com.traveler.model.Recommand;

public class RecommandUnRegisterService {

	RecommandDao recommandDao;
	
	public void setRecommandDao(RecommandDao dao) {
		this.recommandDao = dao;
	}
	
	@Transactional
	public void delete(int listNo) {
		recommandDao.recommandDelete(listNo);
		
	}
}
