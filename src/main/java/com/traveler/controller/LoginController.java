package com.traveler.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.traveler.command.LoginCommand;
import com.traveler.exception.LoginFailException;
import com.traveler.model.Member;
import com.traveler.service.LoginService;

@Controller
@RequestMapping("/traveler/member")
public class LoginController {
	static Log log = LogFactory.getLog(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String getLoginView(){
		log.info("getLoginView()...");
		
		return "traveler/member/loginForm";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public LoginCommand login(@RequestBody LoginCommand command, HttpSession session){
		log.info("id = " + command.getId());
		log.info("password = " + command.getPassword());
		
		Member member = loginService.login(command.getId(), command.getPassword());
		session.setAttribute("login", true);
		session.setAttribute("member", member);
		
		return command;
	}
	
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpSession session) {
		log.info("logout()...");
		
		session.invalidate(); //session 날리기
		return "redirect:/traveler/member/login.html";
	}
	
	
	@RequestMapping(value ="/logincheck", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> loginCheck(HttpSession session){
		Map<String, Object> map = new HashMap<>();
		
		Boolean login = (Boolean) session.getAttribute("login");
		if (login != null && login == true) {
			map.put("login", true);
			map.put("member", session.getAttribute("member"));
		}else{
			map.put("login", false);
		}
		
		return map;
	}
	
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> loginFail(LoginFailException e){
		Map<String, Object> error = new HashMap<String,Object>();
		error.put("message", e.getMessage());
		return error;
		
	}
}
