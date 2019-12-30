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

import com.traveler.command.RealTimeCommand;
import com.traveler.model.RealTime;
import com.traveler.model.RealTimeList;
import com.traveler.model.RealTimePage;
import com.traveler.service.RealTimeDetailService;
import com.traveler.service.RealTimeListService;
import com.traveler.service.RealTimePageService;
import com.traveler.service.RealTimeRegisterService;
import com.traveler.service.RealTimeUnRegisterService;

@Controller
@RequestMapping("/traveler/realTime/")
public class RealTimeController {
	static Log log = LogFactory.getLog(RealTimeController.class);

	@Autowired
	RealTimeDetailService realTimeDetailService;
	@Autowired
	RealTimeListService  realTimeListService;
	@Autowired
	RealTimePageService  realTimePageService;
	@Autowired
	RealTimeRegisterService realTimeRegisterService;
	@Autowired
	RealTimeUnRegisterService	realTimeUnRegisterService;
	

	@RequestMapping(value="realTimeMain.html")
	public String getRealTimeMainView(){
		log.info("getMainView()...");
		
		return "traveler/realTime/realTimeMain";
	}
	
   @RequestMapping(value="/realTimeList.html",method=RequestMethod.GET)
   public String getRealTimeListView()
   {
      log.info("getListView()...");
      
      return "traveler/realTime/realTimeList";    
   }
   
   @RequestMapping(value="/realTimeInsert.html",method=RequestMethod.GET)  
   public String getRealTimeAppendView()
   {
      log.info("getRealTimeAppendView()...");
      
      return "traveler/realTime/realTimeInsert";    
   }
   
   @RequestMapping(value="/realTimeDelete.html",method=RequestMethod.GET)  
   public String getRealTimeDeleteView()
   {
	   log.info("getRealTimeDeleteView()...");
	   
	   return "traveler/realTime/realTimeDelete";    
   }
   
   
	@RequestMapping(value={"","/"},method=RequestMethod.GET) 
	@ResponseBody
	public RealTimeList getRealTimeAll()
	{
		  log.info("getRealTimeAll()....");
		  RealTimeList list = realTimeListService.getList(); 
	      return list; 
	}
	
	@RequestMapping(value="/{number:[0-9]+}",method=RequestMethod.GET)
	   @ResponseBody
	   public RealTime getRealTimeItem(@PathVariable int number){
	      log.info("getRealTimeItem().... number = "+number);
	      
	      RealTime realTime = realTimeDetailService.realTimeDetail(number);
	      return realTime;		//spring이 자동으로 json 형태로 리턴
	   }
	   
	//   @RequestMapping("/page/{pageNo:[\\-\\+]{0,1}[0-9]+}")
	//   {0,1} 0번 또는 1번 실행
	//   [\\-\\+] - + 부호를 나타내려고 \\사용해서 -와 + 표현
	   
	   /*
	    *    URL_GET_PAGE = [/city/page/{pageNo}]
	    *    Accept = application/json
	    */
	   @RequestMapping(value="/page/{pageNo:[0-9]+}",method=RequestMethod.GET)
	   @ResponseBody//json or xml로 return받기위해
	   public RealTimePage getRealTimePage(@PathVariable int pageNo){
	      log.info("pageNo = " + pageNo);
	      RealTimePage page = realTimePageService.getPage(pageNo);	
	      return page;
	   }
	   
	   
	   @RequestMapping(value={"","/"}, method=RequestMethod.POST)				//POST로 요청을 하면 입력으로 응답
	   @ResponseBody
	   public RealTimeCommand RealTimeAppend(@RequestBody RealTimeCommand command) throws Exception{		
		   log.info("postRealTimeAppend()... realTime.id = " + command.getId());
		   
		   command.validate();
		   
		   if(!command.isValid())		//에러발생시 ajax에서 errorcallback 호출
		   {
			   //throw
		   }
		   String id = realTimeRegisterService.regist(command.getRealTime());
		   command.setId(id);
		   return command;
	   }
	   
	   @RequestMapping(value={"/{number:[0-9]+}"}, method=RequestMethod.DELETE)		
	   @ResponseBody
	   public void deleteRealTime(@PathVariable int number)
	   {
		   log.info("deleteRealTime()..." +number);
		   realTimeUnRegisterService.unRegist(number);
	   }

}
