package com.traveler.service;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.ShareDao;
import com.traveler.exception.ShareRegisterException;
import com.traveler.model.Share;

public class ShareRegisterService {
	
	static Log log = LogFactory.getLog(ShareRegisterService.class);
	
	ShareDao shareDao;
	
	public void setShareDao(ShareDao dao) {
		this.shareDao = dao;
	}
	
	@Transactional
	public String regist(Share share) throws Exception
	{
		String id = null;
		
		try{
			id = shareDao.insert(share);
		}catch(DataIntegrityViolationException e)
		{
			log.error(e);
			throw new ShareRegisterException();
		}
		return id;
	}
}
