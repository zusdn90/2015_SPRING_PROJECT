package com.traveler.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traveler.command.MemberCommand;
import com.traveler.service.MemberRegisterService;

@Controller
@RequestMapping("/traveler/member")
public class MemberController {
	static Log log = LogFactory.getLog(MemberController.class);
	
	@RequestMapping(value="login.html")
	public String getLoginView(){
		log.info("getLoginView()...");
		
		return "traveler/member/loginForm";
	}
	
	@RequestMapping(value="memberMain.html")
	public String getMainView(){
		log.info("getMainView()...");
		
		return "traveler/member/main";
	}
	
}
