package com.traveler.service;

import com.traveler.dao.ShareDao;

public class ShareUnRegisterService {
		ShareDao shareDao;
		
		public void setShareDao(ShareDao dao)
		{
			this.shareDao = dao;
		}
		
		public int unRegist(int boardNum)
		{
			shareDao.deleteByboardNum(boardNum);
			
			return boardNum;
		}

}
