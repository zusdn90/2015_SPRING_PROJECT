package com.traveler.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traveler.command.MemberCommand;
import com.traveler.model.Member;
import com.traveler.model.MemberList;
import com.traveler.model.MemberPage;
import com.traveler.service.MemberDetailService;
import com.traveler.service.MemberListService;
import com.traveler.service.MemberModifyService;
import com.traveler.service.MemberPageService;
import com.traveler.service.MemberRegisterService;
import com.traveler.service.MemberUnRegisterService;

@Controller
@RequestMapping("/traveler/admin")
public class AdminController {
	static Log log = LogFactory.getLog(AdminController.class);
	
	@Autowired	// 필드 주입
	MemberListService memberListService;
	
	@Autowired
	MemberPageService memberPageService;
	
	@Autowired
	MemberRegisterService memberRegisterService;
	
	@Autowired
	MemberDetailService memberDetailService;
	
	@Autowired
	MemberModifyService memberModifyService;
	
	@Autowired
	MemberUnRegisterService memberUnRegisterService; //delete
	
	/*
	 * main.html
	 */
	@RequestMapping(value="main.html", method=RequestMethod.GET)
	public String getMainView(){
		log.info("getMainView()...");
		
		return "traveler/admin/main";
	}
	/*
	 * list.html
	 */
	@RequestMapping(value="memberList.html", method=RequestMethod.GET)
	public String getMemberListView(){
		log.info("getMemberListView()...");
		
		return "traveler/admin/memberList";
	}
	
	/*
	 * detail.html
	 */
	@RequestMapping(value="memberdetail.html", method=RequestMethod.GET)
	public String getDetailView() {
		log.info("getDetailView()...");
		
		return "traveler/admin/memberdetail"; 
	}
	/*
	 * append.html
	 */
	@RequestMapping(value="memberappend.html", method=RequestMethod.GET)
	public String getAppendView() {
		log.info("getAppendView()...");
		
		return "traveler/admin/memberappend"; 
	}
	/*
	 * modify.html
	 */
	@RequestMapping(value="membermodify.html", method=RequestMethod.GET)
	public String getModifyView() {
		log.info("getModifyView()...");
		
		return "traveler/admin/membermodify"; 
	}
	/*
	 * delete.html  = .html은 뷰 라는 의미
	 */
	@RequestMapping(value="memberdelete.html", method=RequestMethod.GET)
	public String getDeleteView() {
		log.info("getDeleteView()...");
		
		return "traveler/admin/memberdelete"; 
	}
	
	
	
	/*
	 *  URL_GET_LIST = [/city] or [/city/]
	 *  Accept = application/json
	 */
	@RequestMapping(value={"", "/"}, method=RequestMethod.GET)
	@ResponseBody
	public MemberList getMemberAll() {
		log.info("getMemberAll()...");
		
		MemberList memberList = memberListService.getMemberList();
		
		return memberList;
	}
	
	/*
	 * URL_GET_ITEM_BASE = [/city/{id}]
	 * detail서비스
	 * Accept = application/json
	 */
	@RequestMapping(value="/{num}", method=RequestMethod.GET)
	@ResponseBody
	public Member getMemberItem(@PathVariable int num) {
		log.info("getMemberItem()... num=" + num);
		
		Member member = memberDetailService.detail(num);
		
		return member;
	}
	
	/*
	 *  URL_GET_PAGE_BASE = [/city/page/{pageNo}]
	 *  Accept = application/json
	 */	
	@RequestMapping(value="/page/{pageNo:[0-9]+}", method=RequestMethod.GET)
	@ResponseBody
	public MemberPage getMemberPage(@PathVariable int pageNo) {
		log.info("getMemberPage()... pageNo = " + pageNo);
		
		MemberPage page = memberPageService.getPage(pageNo);
		
		return page;
	}
	/*
	 * 	URL_POST_ITEM_APPEND = [/city] or [/city/]
	 *  Accept = application/json
	 */
	@RequestMapping(value={"", "/"}, method=RequestMethod.POST)
	@ResponseBody
	public MemberCommand postMemberAppend(@RequestBody MemberCommand command) {
		log.info("postMeberAppend()... member num = " + command.getNum());
		
//		command.validate();
//		
//		if (!command.isValid()) {
//			// throw 
//		}
		
		int num = memberRegisterService.regist(command.getMember());
		command.setNum(num);
		
		return command;
	}
	/*
	 * 	URL_PUT_ITEM_MODIFY = [/city/{id}]
	 *  Accept = application/json
	 */
	@RequestMapping(value="/{num}", method=RequestMethod.PUT)
	@ResponseBody
	public MemberCommand putMemberModify(@PathVariable int num, @RequestBody MemberCommand command) {
		log.info("putMemberModify()... num = " + num);
		log.info("putMemberModify()... member num = " + command.getNum());
		
		memberModifyService.modify(command.getMember());
		
		return command;
	}
	/*
	 * 	URL_DELETE_ITEM_DELETE = [/city/{id}]
	 *  Accept = application/json
	 */
	@RequestMapping(value="/{num}", method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteMember(@PathVariable int num) {
		log.info("deleteMember()... num = " + num);

		memberUnRegisterService.unregist(num);
	}
	
	@RequestMapping("/chkId")
	@ResponseBody
	public Map<String, String> chkId(String ckid) throws Exception {
	  
		  Map<String, String> resultMap = new HashMap<String, String>();
		  
		  int resultCnt = MemberRegisterService.chkId(ckid);
		  String result = "";
		  String resultMsg = "";
		  if ( resultCnt == 0 ){
		   result = "success";
		   resultMsg = "사용가능한 아이디입니다.";
		  } else {
		   result = "failure";
		   resultMsg = "이미 사용중인 아이디입니다.";
		  }
		  
		  resultMap.put("result", result);
		  resultMap.put("resultMsg", resultMsg);
		  
		  return resultMap;
	 } 
}
