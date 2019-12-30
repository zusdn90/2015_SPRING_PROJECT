package com.hybrid.service;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.traveler.exception.RecommandRegisterException;
import com.traveler.model.Comment;
import com.traveler.model.Recommand;
import com.traveler.service.CommentRegisterService;
import com.traveler.service.CommentService;
import com.traveler.service.RecommandDetailService;
import com.traveler.service.ShareCommentRegisterService;
import com.traveler.service.ShareDetailService;

public class RecommandRegisterServiceTest {

	static Log log = LogFactory.getLog(RecommandRegisterServiceTest.class);
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=null;
		ctx = new GenericXmlApplicationContext(
				"spring/beans_service.xml", 
				"spring/beans_dao.xml");
		
//		RecommandPageService service = ctx.getBean(RecommandPageService.class);
//		RecommandRegisterService service = ctx.getBean(RecommandRegisterService.class);
//		RecommandDetailService service = ctx.getBean(RecommandDetailService.class);
//		RecommandUnRegisterService service = ctx.getBean(RecommandUnRegisterService.class);
//		RecommandModifyService service = ctx.getBean(RecommandModifyService.class);
//		CommentService service = ctx.getBean(CommentService.class);
//		CommentRegisterService service = ctx.getBean(CommentRegisterService.class);
//		ShareCommentRegisterService service = ctx.getBean(ShareCommentRegisterService.class);
		ShareDetailService service = ctx.getBean(ShareDetailService.class);
			service.shareDetail(1);
			
			log.info(service.shareDetail(1));
	
	}

}
