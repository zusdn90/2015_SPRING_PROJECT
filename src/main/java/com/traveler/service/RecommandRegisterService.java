package com.traveler.service;


import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.traveler.dao.RecommandDao;
import com.traveler.exception.RecommandRegisterException;
import com.traveler.model.Recommand;

public class RecommandRegisterService {
	Log log = LogFactory.getLog(RecommandRegisterService.class);
	RecommandDao recommandDao;
	
	public void setRecommandDao(RecommandDao dao) {
		this.recommandDao = dao;
	}
	
	@Transactional
	public int regist(Recommand recommand) {
		int id=0;
		try {
			id = recommandDao.recommandInsert(recommand);
		     
		} catch (DataIntegrityViolationException e) {
			throw new RecommandRegisterException();
		}
		
		return id;
	}
}
