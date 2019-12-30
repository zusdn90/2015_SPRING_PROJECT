package com.traveler.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.ShareDao;
import com.traveler.model.Share;
import com.traveler.model.SharePage;
import com.traveler.util.Pagination;

public class SharePageService {
	ShareDao shareDao;
	
	public void setShareDao(ShareDao dao)
	{
		this.shareDao = dao;
	}

	@Transactional
	public SharePage getPage(int pageNo)
	{
		Pagination paging = new Pagination();
		paging.setPageNo(pageNo);
		paging.setTotalItem(shareDao.selectCount());
		List<Share> list = shareDao.selectPage(paging);
		
		SharePage page = new SharePage();
		page.setPaging(paging);
		page.setShares(list);
		return page;
	}

}
