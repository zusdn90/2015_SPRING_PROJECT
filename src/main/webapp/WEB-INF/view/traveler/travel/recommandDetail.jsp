<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html class="ng-scope" lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/common.jspf" %>
<title>recommandList.jsp</title>
<style type="text/css">
.btn{
	font-weight: bold;
}
</style>
</head>
<body class="container">
<hr>
<div align="center">
	<i class="fa fa-twitter-square fa-5x text-primary"></i>&nbsp;
	<font color="#337ab7" style="" size="30" face="한컴 소망 B">추천 여행지</font>
</div>
<hr>
<div align="center">
<form class="form-horizontal" novalidate="novalidate" name="commentForm" data-ng-submit="submit()">
  <fieldset>
     <div class="form-group">
      <div class="col-sm-12">
      <button type="button" class="btn btn-default col-sm-10 col-sm-offset-1" data-ng-click="cancel()">목록으로 돌아가기.</button>
      </div>
    </div>
    <div class="form-group ">
      <div class="col-sm-2 col-sm-offset-7">
     	<a data-ng-show="c()" href="#/recommandModify/{{recommand.listNo}}" class="btn btn-success">수정</a>
	 	<a data-ng-show="c()" href="#/recommandDelete/{{recommand.listNo}}" class="btn btn-info">삭제</a>
      </div>
    </div>
  </fieldset>
</form>
</div>
<div class="row">
	<div class="col-sm-4 col-lg-offset-1">
			<div class="panel panel-primary" style="text-align: center;">
				<div class="panel-heading"><b>제목</b></div>
				<div class="panel-body">
					{{recommand.title}}
				</div>
			</div>
			<div class="panel panel-primary" style="text-align: center;">
				<div class="panel-heading"><b>작성자</b></div>
				<div class="panel-body">
					{{recommand.name}}
				</div>
			</div>
			<div class="panel panel-primary" style="text-align: center;">
				<div class="panel-heading"><b>장소</b></div>
				<div class="panel-body">
					{{recommand.area}}
				</div>
			</div>
		<div class="panel panel-primary">
		<div class="panel-heading"><b>댓글</b></div>
		<div class="panel-body">
				<div data-ng-repeat="comment in recommand.comments">
					<label>{{comment.id}}</label>
	  				<div style="width:380px;padding:0 5px;overflow:hidden;text-overflow:ellipsis;">
	  						{{comment.content}}
	  				</div>
	  			<hr>
		</div>
		
		<form class="form-horizontal" name="replyForm" novalidate="novalidate" data-ng-submit="submit()">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="reply"></label>
				<div class="col-sm-12" align="right">
							<textarea class="form-control" rows="5" 
							id="reply" name="reply"
							placeholder="댓글등록" data-ng-model="content.content"></textarea>
							<input type="button"
								   class="btn btn-info" 
								   data-ng-show="loginstatus" 
								   data-ng-click="click()"
								   data-ng-disabled="commentForm.comment.$invalid"
								   value="등록" />
				</div>  
			</div>	
		</form>
		</div>
		</div>
	</div>
	
	<div class="col-sm-6">
			<div class="panel panel-primary" style="text-align: center;">
				<div class="panel-heading"><b>내용</b></div>
				<div class="panel-body">
					<img alt="" src="../../img/{{recommand.picture}}" width="250" height="250"><BR>
      			<textarea cols="78" rows="20" style="border: 0;" readonly="readonly">{{recommand.content}}
      			</textarea>
				</div>
			</div>
	</div>
</div>
</div>

</body>
</html>