package com.traveler.service;

import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.ShareDao;
import com.traveler.model.Share;

public class ShareModifyService {
	ShareDao shareDao;
	
	public void setShareDao(ShareDao dao)
	{
		this.shareDao = dao;
	}
	
	@Transactional
	public int modify(Share share)
	{
		shareDao.update(share);
		
		return share.getBoardNum();
	}
}
