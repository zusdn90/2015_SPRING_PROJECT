<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<!DOCTYPE html>
<html lang="ko" data-ng-app="travelerApp">
<%@ include file="/WEB-INF/view/common.jspf" %>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>shareInsert.jsp</title>
<style type="text/css">
.filebox.bs3-success label {
  color: #fff;
  background-color: #5cb85c;
  border-color: #4cae4c;
}
input#btn {
	font-weight:bold;
}
.btn{
	font-weight: bold;
}
</style>

</head>
<body  data-ng-controller="shareController"  class="container">
<hr>
	<div align="center">
		<i class="fa fa-map-marker fa-5x text-primary"></i>&nbsp; <font
			color="#337ab7" style="" size="30" face="한컴 소망 B">공유게시판 글쓰기</font>
	</div>
	<hr>
<div class="row">
	<div class="col-sm-8 col-sm-offset-2">
		<div class="panel panel-primary">
		<div class="panel-heading"><b>정보 입력</b></div>
		<div class="panel-body">
					<form class="form-horizontal" name="shareForm" id="shareForm"
						method="post" enctype="multipart/form-data"
						novalidate="novalidate" data-ng-submit="submit()">
						<!-- name -->
						<div class="form-group">
							<div class="col-sm-8">
								<input id="name" name="name" type="hidden" class="form-control"
									required="required" data-ng-model="member.name"
									data-ng-maxlength="15" disabled="disabled"/>
							</div>
						</div>
						<!-- title -->
						<div class="form-group">
							<label class="col-sm-2 control-label" for="title">제목 :</label>
							<div class="col-sm-8">
								<input id="title" name="title" type="text" class="form-control"
									required="required" data-ng-model="share.title"
									data-ng-maxlength="15" />
							<div data-ng-show="shareForm.title.$dirty">
								<div class="alert alert-warning"
									data-ng-show="shareForm.title.$error.required">필수 입력
									항목입니다.</div>
								<div class="alert alert-warning"
									data-ng-show="shareForm.title.$error.maxlength">15자리까지
									입력가능합니다.</div>
							</div>
							</div>
						</div>
						<div class="form-group">
							<!-- term -->
							<label class="col-sm-2 control-label" for="term">기간 :</label>
							<div class="col-sm-8">
								<input id="term" name="term" type="text" class="form-control"
									required="required" data-ng-model="share.term"
									data-ng-maxlength="30" />
							
							<div data-ng-show="shareForm.term.$dirty">
								<div class="alert alert-warning"
									data-ng-show="shareForm.term.$error.required">필수 입력
									항목입니다.</div>
								<div class="alert alert-warning"
									data-ng-show="shareForm.term.$error.maxlength">최대 30자 까지 입력가능합니다.</div>
							</div>
							</div>
						</div>
						<div class="form-group">
							<!-- number -->
							<label class="col-sm-2 control-label" for="number">인원 :</label>
							<div class="col-sm-8">
								<input id="number" name="number" type="number"
									class="form-control" required="required"
									data-ng-model="share.number" data-ng-maxlength="3" />
							
							<div data-ng-show="shareForm.number.$dirty">
								<div class="alert alert-warning"
									data-ng-show="shareForm.number.$error.required">필수 입력
									항목입니다.</div>
								<div class="alert alert-warning"
									data-ng-show="shareForm.number.$error.maxlength">최대 100자릿수 까지 입력가능합니다. 최대 999</div>
							</div>
							</div>
						</div>

						<div class="form-group">
							<!-- cost -->
							<label class="col-sm-2 control-label" for="cost">비용 :</label>
							<div class="col-sm-8">
								<b>교통비</b>
								<input id="transCost" name="transCost" type="number" class="form-control"
									required="required" data-ng-maxlength="15"
									data-ng-model="share.transCost" placeholder="교통비:" /> 
								<b>숙박비</b>	
								<input id="stayCost" name="stayCost" type="number" class="form-control"
									required="required" data-ng-maxlength="15"
									data-ng-model="share.stayCost" placeholder="숙박비:" /> 
								<b>식비</b>	
								<input id="eatCost" name="eatCost" type="number" class="form-control"
									required="required" data-ng-maxlength="15"
									data-ng-model="share.eatCost" placeholder="식비:" />
								Total : {{share.transCost+share.stayCost+share.eatCost}}원
							</div>
						
						<div data-ng-show="shareForm.cost.$dirty">
							<div class="alert alert-warning"
								data-ng-show="shareForm.cost.$error.required">필수 입력 항목입니다.</div>
						</div>
						</div>
						
						<div class="form-group">
							<!-- content -->
							<label class="col-sm-2 control-label" for="content">내용 :</label>
							<div class="col-sm-8">
								<textarea class="form-control" rows="5" id="content" name="content"
								required="required"
									data-ng-model="share.content"></textarea>
							</div>
						
						<div class="col-sm-8 col-sm-offset-2" data-ng-show="shareForm.content.$dirty">
							<div class="alert alert-warning"
								data-ng-show="shareForm.content.$error.required">필수 입력 항목입니다.</div>
						</div>
						</div>
						<div class="form-group">
					      <label for="picture" class="col-sm-2 control-label">사진</label>
					      <div class="col-sm-8">
					        <input type="file" 
					        	   multiple 
					        	   class="file"
					        	   name="imageFile"
					        	   id="picture" 
					        	   size="50"
					        	   >
					      </div>
					    </div>
						<div class="form-group">
							<!-- map -->
							<label class="col-sm-2 control-label" for="map">경로 :</label>
							<div class="col-sm-8">
								<textarea data-ng-model="share.map" class="form-control"
									rows="5" id="map" required="required"
									placeholder="ex) 지역:서울 >> 경복궁  >> 인사동 >> 광장시장 >> 낙성대 >> 명동 "></textarea>
							</div>
						</div>
						<div data-ng-show="shareForm.map.$dirty">
							<div class="alert alert-warning"
								data-ng-show="shareForm.map.$error.required">필수 입력 항목입니다.</div>
						</div>

						<!-- Submit -->
						<div class="form-group" align="center">
							<input type="submit" value="확인" class="btn btn-primary"
							data-ng-click="toggle()"
							data-ng-disabled="shareForm.$invalid" />
							<a href="#/shareList">
			            <input type="button"
			                   class="btn btn-success"
			                   value="취소"
			                   />
			            </a>
						</div>
					</form>
				</div>
			</div>
	</div>
</div>

</body>
</html>