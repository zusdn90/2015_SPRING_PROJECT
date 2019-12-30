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

import com.traveler.command.ShareCommand;
import com.traveler.model.Comment;
import com.traveler.model.Share;
import com.traveler.model.ShareList;
import com.traveler.model.SharePage;
import com.traveler.service.ShareCommentRegisterService;
import com.traveler.service.ShareDetailService;
import com.traveler.service.ShareListService;
import com.traveler.service.ShareModifyService;
import com.traveler.service.SharePageService;
import com.traveler.service.ShareRegisterService;
import com.traveler.service.ShareUnRegisterService;

@Controller
@RequestMapping("/traveler/travel/")
public class ShareController{
	static Log log = LogFactory.getLog(ShareController.class);

	 @Autowired		//필드 주입
	 ShareListService shareListService;
	 
	 @Autowired
	 ShareDetailService shareDetailService;
	 
	 @Autowired
	 SharePageService sharePageService;
	 
	 @Autowired
	 ShareRegisterService shareRegisterService;
	 
	 @Autowired
	 ShareUnRegisterService shareUnRegisterService;
	 
	 @Autowired
	 ShareModifyService shareModifyService;
 
	 @Autowired
	 ShareCommentRegisterService shareCommentRegisterService;
	
	  
		@RequestMapping(value="shareMain.html")
		public String getShareMainView(){
			log.info("getMainView()...");
			
			return "traveler/travel/shareMain";
		}
		
	   @RequestMapping(value="/shareList.html",method=RequestMethod.GET)
	   public String getShareListView()
	   {
	      log.info("getListView()...");
	      
	      return "traveler/travel/shareList";    
	   }
	
	   @RequestMapping(value="/shareDetail.html",method=RequestMethod.GET)   
	   public String getDetailView()
	   {
	      log.info("getDetailView()...");
	      
	      return "traveler/travel/shareDetail";      
	   }
	
	   @RequestMapping(value="/shareInsert.html",method=RequestMethod.GET)  
	   public String getAppendView()
	   {
	      log.info("getAppendView()...");
	      
	      return "traveler/travel/shareInsert";    
	   }
	   
	   @RequestMapping(value="/shareModify.html",method=RequestMethod.GET)   // modify.html 요청이 들어오면 getModifyView가 실행가 실행되면서 /WEB-INF/view/traveler/shareModify.jsp 이것이 실행된다.
	   public String getModifyView()
	   {
	      log.info("getModifyView()...");
	      
	      return "traveler/travel/shareModify";      // 논리적인view로 취급하여 return   
	   }
	   
	   
	   	@RequestMapping(value="/shareDelete.html",method=RequestMethod.GET)
	   	public String getDeleteView()
	   	{
	   		log.info("getDeleteView()...");
	   		return "traveler/travel/shareDelete";
	   	}
	
	 
		@RequestMapping(value={"","/"},method=RequestMethod.GET) 
		@ResponseBody
		public ShareList getShareAll()
		{
			  log.info("getShareAll()....");
		      ShareList list = shareListService.getList(); 
		      return list; 
		}
		
	  
	   @RequestMapping(value="/{boardNum:[0-9]+}",method=RequestMethod.GET)
	   @ResponseBody
	   public Share getShareItem(@PathVariable int boardNum){
	      log.info("getShareItem().... boardNum = "+boardNum);
	      
	      Share share = shareDetailService.shareDetail(boardNum);
	      
	      return share;		//spring이 자동으로 json 형태로 리턴
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
	   public SharePage getSharePage(@PathVariable int pageNo){
	      log.info("pageNo = " + pageNo);
	      SharePage page = sharePageService.getPage(pageNo);	
	      return page;
	   }
	   
	   @RequestMapping(value={"","/"}, method=RequestMethod.POST)				//POST로 요청을 하면 입력으로 응답
	   @ResponseBody
	   public ShareCommand postShareAppend(@RequestBody ShareCommand command) throws Exception{		
		   log.info("postShareAppend()... share.id = " + command.getId());
		   
		   command.validate();
		   
		   if(!command.isValid())		//에러발생시 ajax에서 errorcallback 호출
		   {
			   //throw
		   }
		   String id = shareRegisterService.regist(command.getShare());
		   command.setId(id);
		   
		   return command;
	   }	
	   
	   
	   /*
	    *	URL_PUT_ITEM_MODIFY = [/share/{boardNum}]  
	    *	Accept = application/json
	    */
	   @RequestMapping(value={"/{boardNum:[0-9]+}"}, method=RequestMethod.PUT)		
	   @ResponseBody
	   public ShareCommand putShareModify(@PathVariable int boardNum, @RequestBody ShareCommand command){
		   log.info("putShareModify()... boardNum = " + boardNum);
		   log.info("putShareModify()... share.boardNum = " + command.getBoardNum());
		   
		   shareModifyService.modify(command.getShare());
		   return command;
	   }
	   
	   @RequestMapping(value={"/{boardNum:[0-9]+}"}, method=RequestMethod.DELETE)		
	   @ResponseBody
	   public void deleteShare(@PathVariable int boardNum)
	   {
		   log.info("deleteShare()..." +boardNum);
		   
		   shareUnRegisterService.unRegist(boardNum);
	   }
	   
		@RequestMapping(value="/{listNo}", method=RequestMethod.POST)
		@ResponseBody
		public Comment postCommentAppend(@PathVariable int listNo,@RequestBody Comment comment) {
			log.info("postCommentAppend()... getContent = " + comment.getContent());
			log.info("postCommentAppend()... getId = " + comment.getId());
			log.info("postCommentAppend()... listNo = " + listNo);
			log.info("postCommentAppend()... getListNo = " + comment.getListNo());
			
			shareCommentRegisterService.regist(comment);
			
			return comment;
		}
	
}



