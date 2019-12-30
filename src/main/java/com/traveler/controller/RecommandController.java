package com.traveler.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traveler.command.RecommandCommand;
import com.traveler.model.Comment;
import com.traveler.model.Recommand;
import com.traveler.model.RecommandList;
import com.traveler.model.RecommandPage;
import com.traveler.service.CommentRegisterService;
import com.traveler.service.CommentService;
import com.traveler.service.RecommandDetailService;
import com.traveler.service.RecommandListService;
import com.traveler.service.RecommandModifyService;
import com.traveler.service.RecommandPageService;
import com.traveler.service.RecommandRegisterService;
import com.traveler.service.RecommandUnRegisterService;

@Controller
@RequestMapping("/traveler/recommand")
public class RecommandController {
	static Log log = LogFactory.getLog(RecommandController.class);
	
	@Autowired
	RecommandListService recommandListService;
	
	@Autowired
	RecommandPageService recommandPageService;
	
	@Autowired
	RecommandRegisterService recommandRegisterService;
	
	@Autowired
	RecommandDetailService recommandDetailService;
	
	@Autowired
	RecommandUnRegisterService recommandUnRegisterService;
	
	@Autowired
	RecommandModifyService recommandModifyService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	CommentRegisterService commentRegisterService;
	
	@RequestMapping(value="/recommandMain.html")
	public String getRecommandMainView(){
		log.info("getRecommandMainView()...");
		
		return "traveler/travel/recommandMain";
	}
	
	@RequestMapping(value="/recommandList.html")
	public String getRecommandListView(){
		log.info("getRecommandListView()...");
		
		return "traveler/travel/recommandList";
	}
	
	@RequestMapping(value="recommandInsert.html")
	public String getrecommandInsertView(){
		log.info("getrecommandInsertView()...");
		
		return "traveler/travel/recommandInsert";
	}
	
	@RequestMapping(value="recommandModify.html")
	public String getrecommandModifyView(){
		log.info("getrecommandModifyView()...");
		
		return "traveler/travel/recommandModify";
	}
	
	@RequestMapping(value="recommandDelete.html")
	public String getrecommandDeleteView(){
		log.info("getrecommandDeleteView()...");
		
		return "traveler/travel/recommandDelete";
	}
	
	@RequestMapping(value="recommandDetail.html")
	public String getrecommandDetailView(){
		log.info("getrecommandDetailView()...");
		
		return "traveler/travel/recommandDetail";
	}
	
	@RequestMapping(value={"", "/"}, method=RequestMethod.GET)
	@ResponseBody
	public RecommandList getRecommandAll() {
		log.info("getRecommandAll...");
		
		RecommandList list = recommandListService.getList();
		
		return list;
	}
	
	@RequestMapping(value="/{listNo}", method=RequestMethod.GET)
	@ResponseBody
	public Recommand getRecommandItem(@PathVariable int listNo) {
		log.info("getRecommandItem()... listNo=" + listNo);
		
		Recommand recommand = recommandDetailService.detail(listNo);
		
		return recommand;
	}
	

	
	@RequestMapping(value="/{listNo}", method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecommandItem(@PathVariable int listNo) {
		log.info("deleteRecommandItem()... listNo=" + listNo);
		
		recommandUnRegisterService.delete(listNo);
	}
	
	@RequestMapping(value="/page/{pageNo:[0-9]+}", method=RequestMethod.GET)
	@ResponseBody
	public RecommandPage getRecommandPage(@PathVariable int pageNo) {
		log.info("getRecommandPage()... pageNo = " + pageNo);
		
		RecommandPage page = recommandPageService.getPage(pageNo);
		
		return page;
	}
	
	@RequestMapping(value={"", "/"}, method=RequestMethod.POST)
	@ResponseBody
	public RecommandCommand postRecommandAppend(@RequestBody RecommandCommand recommand) {
		log.info("postRecommandAppend()... picture = " + recommand.getPicture());
		log.info("postRecommandAppend()... title = " + recommand.getTitle());
		log.info("postRecommandAppend()... name = " + recommand.getName());
		log.info("postRecommandAppend()... content = " + recommand.getContent());
		log.info("postRecommandAppend()... area = " + recommand.getArea());
		recommand.validate();
		
		if (!recommand.isValid()) {
			// throw 
		}
		
		recommandRegisterService.regist(recommand.getRecommand());
		
		return recommand;
	}
	
	@RequestMapping(value="/{listNo}", method=RequestMethod.POST)
	@ResponseBody
	public Comment postCommentAppend(@PathVariable int listNo,@RequestBody Comment comment) {
		log.info("postCommentAppend()... getContent = " + comment.getContent());
		log.info("postCommentAppend()... getId = " + comment.getId());
		log.info("postCommentAppend()... listNo = " + listNo);
		log.info("postCommentAppend()... getListNo = " + comment.getListNo());
		
		commentRegisterService.regist(comment);
		
		return comment;
	}
	
	
	@RequestMapping(value="/{listNo}", method=RequestMethod.PUT)
	@ResponseBody
	public RecommandCommand putRecommandModify(@PathVariable int listNo, @RequestBody RecommandCommand recommand) {
		log.info("listNo = "+ listNo);
		log.info("putRecommandModify()... picture = " + recommand.getPicture());
		log.info("putRecommandModify()... title = " + recommand.getTitle());
		log.info("putRecommandModify()... name = " + recommand.getName());
		log.info("putRecommandModify()... content = " + recommand.getContent());
		log.info("putRecommandModify()... area = " + recommand.getArea());
		recommand.setListNo(listNo);
		log.info("putRecommandModify()... listNo = " + recommand.getListNo());
		recommand.validate();
		
		if (!recommand.isValid()) {
			// throw  
		}
		recommandModifyService.update(recommand.getRecommand());
		
		
		return recommand;
	}
	
	
	
}
