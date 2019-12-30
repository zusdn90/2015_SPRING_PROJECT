<%@page import="com.traveler.dao.ShareDao"%>
<%@page import="com.traveler.model.Share"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.btn{
	font-weight: bold;
}
</style>
</head>
<body class="container">
<hr>
<div align="center">
<a href="#/shareList">
<button type="button" class="btn btn-primary">게시판으로 돌아가기</button>
</a>
</div>
<hr>
<div class="row">
	<div class="col-sm-4 col-lg-offset-1">
			<div class="panel panel-primary">
			<div class="panel-heading"><b>회원사진</b></div>
			<div class="panel-body">
						<!-- picture -->
						<div class="form-group">
						<label class="col-sm-5 control-label" for="memberPicture"></label>
						<div class="col-sm-8 col-lg-offset-3" align="left">
						<img alt="" src="${pageContext.request.contextPath}/img/{{share.memberPicture}}" width="150" height="150" id="memberPicture"  name="memberPicture" 
							   width="200" height="200">
					</div>
				</div>
			</div>
			</div>
		<div class="panel panel-primary">
		<div class="panel-heading"><b>프로필</b></div>
		<div class="panel-body">
			<form class="form-horizontal" name="shareForm" novalidate="novalidate">
			<!-- ID -->
			<div class="form-group">
				<label class="col-sm-4 control-label" for="id">ID : </label>
				<div class="col-sm-4">
				<input id="id"
					   name="id"
					   type="text" 
					   class="form-control"
					   required="required"
					   data-ng-model="share.id"	
					   data-ng-maxlength="35"
					   disabled="disabled"		
					   />
					 </div>  
				</div>
			<div class="form-group">
				<label class="col-sm-4 control-label" for="age">생년월일 : </label>
				<div class="col-sm-8">
				<input id="age"
					   name="age"
					   type="text" 
					   class="form-control"
					   required="required"
					   data-ng-model="share.birthday"	
					   data-ng-maxlength="35"
					   disabled="disabled"		
					   />
					 </div>  
				</div>
			<div class="form-group">
				<label class="col-sm-4 control-label" for="tel">연락처 : </label>
				<div class="col-sm-8">
				<input id="tel"
					   name="tel"
					   type="text" 
					   class="form-control"
					   required="required"
					   data-ng-model="share.tel"	
					   data-ng-maxlength="35"
					   disabled="disabled"		
					   />
					 </div>  
				</div>
			</form>
		</div>
		</div>
		<div class="panel panel-primary">
		<div class="panel-heading"><b>댓글</b></div>
		<div class="panel-body">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th><th>내용</th>
				</tr>
			</thead>
			<tbody>
				<tr data-ng-repeat="comment in share.comments">
					<td>{{comment.id}}
					</td>
					<td>{{comment.content}}</td>
				</tr>			
			</tbody>		
		</table>
		
		<form class="form-horizontal" name="replyForm" novalidate="novalidate" data-ng-submit="submit()">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="reply"></label>
				<div class="col-sm-8" align="right">
							<textarea class="form-control" rows="5" 
							id="reply" name="reply"
							placeholder="댓글등록" data-ng-model="content.content"></textarea>
							<input type="button"
							class="btn btn-info" data-ng-show="loginstatus" data-ng-click="click()" value="등록" />
				</div>  
			</div>	
		</form>
		</div>
</div>
</div>
	<div class="col-sm-6">
		<div class="panel panel-primary">
		<div class="panel-heading"><b>상세 정보</b></div>
		<div class="panel-body">
			<form class="form-horizontal" name="shareForm" novalidate="novalidate">
			<!-- Name -->
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">작성자 : </label>
				<div class="col-sm-10">
				<input id="name"
					   name="name"
					   type="text" 
					   class="form-control"
					   required="required"
					   data-ng-model="share.writer"	
					   data-ng-maxlength="35"
					   disabled="disabled"		
					   />
					 </div>  
				</div>
				
				<!-- title -->
				<div class="form-group">
					<label class="col-sm-2 control-label" for="title">제목 :</label>
					<div class="col-sm-10">
					<input id="title"
						   name="title"
						   type="text"
						   class="form-control"
						   required="required"
						   data-ng-model="share.title"
						   data-ng-maxlength="15"
						   disabled="disabled"
					/>
					</div>
					<div  data-ng-show="shareForm.title.$dirty">
						   <div class="alert alert-warning" data-ng-show="shareForm.title.$error.required">필수 입력 항목입니다.</div>
						   <div class="alert alert-warning" data-ng-show="shareForm.title.$error.maxlength">15자리까지 입력가능합니다.</div>
					   </div>
				</div>
				<div class="form-group">
					<!-- term -->
					<label class="col-sm-2 control-label" for="term">기간 :</label>
					<div class="col-sm-10">
					<input id="term"
						   name="term"
						   type="text"
						   class="form-control"
						   required="required"
						   data-ng-model="share.term"
						   data-ng-maxlength="15"
						   disabled="disabled"
					/>
					</div>
					<div data-ng-show="shareForm.term.$dirty">
						   <div class="alert alert-warning" data-ng-show="shareForm.term.$error.required">필수 입력 항목입니다.</div>
					   </div>
				</div>
				<div class="form-group">
					<!-- number -->
					<label class="col-sm-2 control-label" for="number">인원 :</label>
					<div class="col-sm-10">
					<input id="number"
						   name="number"
						   type="number"
						   class="form-control"
						   required="required"
						   data-ng-model="share.number"
						   data-ng-maxlength="15"
						   disabled="disabled"
					/>
					</div>
					<div data-ng-show="shareForm.number.$dirty">
						   <div class="alert alert-warning" data-ng-show="shareForm.number.$error.required">필수 입력 항목입니다.</div>
					   </div>
				</div>
				
				<div class="form-group">
							<!-- cost -->
							<label class="col-sm-2 control-label" for="cost">비용 :</label>
							<div class="col-sm-10">
								
								교통비<input id="transCost" name="transCost" type="text" class="form-control"
									required="required" data-ng-maxlength="15"
									data-ng-model="share.transCost" placeholder="교통비:"
									disabled="disabled" /> 
									
								숙박비<input id="stayCost" name="stayCost" type="text" class="form-control"
									required="required" data-ng-maxlength="15"
									data-ng-model="share.stayCost" placeholder="숙박비:" 
									disabled="disabled"/> 
									
								식비<input id="eatCost" name="eatCost" type="text" class="form-control"
									required="required" data-ng-maxlength="15"
									data-ng-model="share.eatCost" placeholder="식비:" 
									disabled="disabled"/>
								
								Total<input id="totalCost" name="totalCost" type="text" class="form-control"
									required="required" data-ng-maxlength="15"
									data-ng-model="share.totalCost" placeholder="총 비용:" 
									disabled="disabled"/>
							</div>
						</div>
						
						<div data-ng-show="shareForm.cost.$dirty">
							<div class="alert alert-warning"
								data-ng-show="shareForm.cost.$error.required">필수 입력 항목입니다.</div>
						</div>
					
					<div class="form-group">
						<!-- content -->
						<label class="col-sm-2 control-label" for="content">내용 :</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="5" 
							id="content" name="content"  data-ng-model="share.content"
							disabled="disabled"></textarea>
						</div>
					</div>
					
					<div class="form-group">
						<!-- picture -->
						<label class="col-sm-2 control-label" for="picture">여행사진:</label>
						<div class="col-sm-10">
						<img alt="" src="${pageContext.request.contextPath}/img/{{share.picture}}" id="picture"  name="picture" 
							   width="150" height="150">
						</div>
					</div>
					
					<div class="form-group">
						<!-- map -->
						<label class="col-sm-2 control-label" for="map">경로 :</label>
						<div class="col-sm-10">
							<textarea data-ng-model="share.map" class="form-control" 
							rows="5" id="map" disabled="disabled"></textarea>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>