<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko" data-ng-app="travelerApp">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">

<style type="text/css">

th {
	text-align: center;
	background-color: #337ab7;
	color: white;
}

td {
	valign:top;
	text-align: center;
}

input#btn {
	font-weight:bold;
}

</style>

</head>
<body class="container" data-ng-controller="realTimeListController">
<hr>
<div align="center">
	<i class="fa fa-twitter-square fa-5x text-primary"></i>&nbsp;
	<font color="#337ab7" style="" size="30" face="한컴 소망 B">실시간 공유 게시판</font>
</div>
<hr>
<div class="table-responsive">

	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th class="col-sm-2">번호</th>
				<th class="col-sm-2">ID</th>
				<th class="col-sm-6">내용</th>
				<th class="col-sm-1">날짜</th>
				<th class="col-sm-1">삭제</th>
			</tr>
		</thead>
		<tbody>
			<tr data-ng-repeat="realTime in realTimes">
				<td align="center">{{realTime.number}}</td>
				<td align="center">{{realTime.id}}</td>
				<td>{{realTime.content}}</td>
				<td>{{realTime.real_date}}</td>
				<td align="center"><a href="#/realTimeDelete/{{realTime.number}}">
					<button class="btn btn-danger" data-ng-show="check()" type="button">
				      <i class='fa fa-trash'></i>
				    </button>
					</a></td>
			</tr>
			<tr align="center"><td colspan="5">
				<uib-pagination 
					 data-total-items="paging.totalItem"
					 data-ng-model="pageNo"
					 data-max-size="10"
					 data-ng-change="selectPage()"
					 data-boundary-links="true">
				</uib-pagination>
				</td>
			</tr>
			</tbody>
		</table>
</div>
<hr>
<div class="form-group">
<div class="panel panel-primary">
<div class="panel-heading"><b>실시간 게시글 작성</b></div>
<div class="panel-body">
<form name="realTimeForm" novalidate="novalidate" data-ng-submit="submit()">
		<textarea rows="5" class="form-control" id="content" name="content" 
				data-ng-model="realTime.content"
				 required="required">
		</textarea>
		 <div data-ng-show="realTimeForm.content.$dirty">
		<div class="alert alert-warning" data-ng-show="realTimeForm.content.$error.required">필수 입력 항목입니다.</div>
		</div>
		<br>
		<button class="btn btn-primary btn-clock" value=""><b>현재시각</b></button>
		<textarea rows="1" class="form-control" id="reg_date" name="reg_date" 
		data-ng-model="realTime.real_date">
		{{realTime.real_date}}
		</textarea>
<br>
	<!-- Submit -->
	<div class="form-group" align="center">
		<input type="submit" 
			   value="등록"
			   id="btn"
			   class="btn btn-primary btn-block"
		 	   data-ng-show="loginstatus"
		 	   data-ng-disabled="realTimeForm.$invalid"/>
	</div>
	
</form>
</div>
</div>
</div>
</body>
</html>




