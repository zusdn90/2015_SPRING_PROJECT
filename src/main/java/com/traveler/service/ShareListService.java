package com.traveler.service;

import java.util.List;

import com.traveler.dao.ShareDao;
import com.traveler.model.Share;
import com.traveler.model.ShareList;

public class ShareListService {
	ShareDao shareDao;
	
	public void setShareDao(ShareDao dao)
	{
		this.shareDao = dao;
	}
	
	public  ShareList getList()
	{
		List<Share> shares = shareDao.selectAll();
		ShareList rtn = new ShareList();
		rtn.setShares(shares);
		return rtn;
	}
}
