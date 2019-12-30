<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
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

.btn{
	font-weight: bold;
}


</style>

</head>
<body class="container">
<div class="table-responsive">
<hr>
<div align="center">
	<i class="fa fa-twitter-square fa-5x text-primary"></i>&nbsp;
	<font color="#337ab7" style="" size="30" face="한컴 소망 B">여행지 공유 게시판</font>
</div>
<hr>
<div><a href="#/shareInsert" data-ng-show="loginstatus" class="btn btn-primary btn-block"><font size="5" face="한컴 윤고딕 250">글쓰기</font></a></div>
<hr>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr style="text-align: center">
				<th class="col-sm-1">게시판번호</th>
				<th class="col-sm-1">ID</th>
				<th class="col-sm-1">작성자</th>
				<th class="col-sm-4">제목</th>
				<th class="col-sm-1">인원</th>
				<th class="col-sm-2">비용</th>
				<th class="col-sm-1">수정</th>
				<th class="col-sm-1">삭제</th>
			</tr>
		</thead>
		<tbody>
			<tr data-ng-repeat="share in shares">
				<td style="padding-top: 15px">{{share.boardNum}}</td>
				<td style="padding-top: 15px">{{share.id}}</td>
				<td style="padding-top: 15px">{{share.writer}}</td>
				<td style="padding-top: 15px"><a href="#/shareDetail/{{share.boardNum}}">{{share.title}}</a></td>
				<td style="padding-top: 15px">{{share.number}}명</td>
				<td style="padding-top: 15px">{{share.totalCost}}원</td>
				<td><a data-ng-show="check()" href="#/shareModify/{{share.boardNum}}">
					<button class="btn btn-info btn" type="button">
				      <i class='fa fa-pencil'></i>
				    </button>
					</a>
				</td>
				<td><a data-ng-show="check()" href="#/shareDelete/{{share.boardNum}}">
					<button class="btn btn-danger" type="button">
				    	<i class='fa fa-trash'></i>
				    </button>
					</a>
				</td>
			</tr>
			</tbody>
			<tr align="center">
			<td colspan="8">
				<uib-pagination 
					 data-total-items="paging.totalItem" 
					 data-ng-model="pageNo"
					 data-max-size="10"
					 data-ng-change="selectPage()"
					 data-boundary-links="true">
				</uib-pagination>
			</td>
			</tr>
		
	</table>
</div>

<hr>	
</body>
</html>




