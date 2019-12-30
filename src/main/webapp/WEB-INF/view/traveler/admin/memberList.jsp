<%@page import="com.traveler.dao.MemberDao"%>
<%@page import="com.traveler.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  

<!DOCTYPE html>
<html lang="ko" data-ng-app="travelerApp">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style type="text/css">
th {
	text-align: center;
	background-color: #5cb85c;
	color: white;
}

td {
	valign:top;
	text-align: center;
}
.results tr[visible='false'],
.no-result{
  display:none;
}

.results tr[visible='true']{
  display:table-row;
}
</style>

<script type="text/javascript">
$(document).ready(function() {
	  $(".search").keyup(function () {
	    var searchTerm = $(".search").val();
	    var listItem = $('.results tbody').children('tr');
	    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
	    
	  $.extend($.expr[':'], {'containsi': function(elem, i, match, array){
	        return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	    }
	  });
	    
	  $(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','false');
	  });

	  $(".results tbody tr:containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','true');
	  });
	});
});

</script>

</head>
<body class="container">
<div class="table-responsive">
	<div>
		<div class="col-lg-12">
			<div class="panel panel-success">
				<div class="panel-heading"><font size="4"><b>회원 목록 - 관리자 전용</b></font></div>
				<hr>
				<div class="col-md-offset-8 input-group">
					<input type="text" class="search form-control" placeholder="검색어를 입력후 엔터를 눌러주세요.">
					<span class="input-group-btn">
						<button class="btn btn-success" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
				<div>
					<a href="#/memberappend" class="center">
						<button class="btn btn-success" type="button">
					      <i class='fa fa-user-plus fa-4x'></i>
					    </button>
					</a>
				</div>
					<div>
						<table class="table table-striped table-bordered table-hover results"" align="center">
							<thead>
								<tr class="center">
									<th class="col-sm-1" scope="row">회원사진</th>
									<th class="col-sm-1" scope="row">회원번호</th>
									<th class="col-sm-1" scope="row">이름</th>
									<th class="col-sm-1" scope="row">아이디</th>
									<th class="col-sm-1" scope="row">생년월일</th>
									<th class="col-sm-3" scope="row">주소</th>
									<th class="col-sm-1" scope="row">우편번호</th>
									<th class="col-sm-1" scope="row">전화번호</th>
									<th class="col-sm-1" scope="row">가입 날짜</th>
									<th class="col-sm-1" colspan="2">수정  / 삭제</th>
								</tr>
							</thead>
							<tbody> 
								<tr data-ng-repeat="member in members">
									<td><img alt="" src="${pageContext.request.contextPath}/img/{{member.memberPicture}}" width="100" height="100"></td>
									<td style="padding-top: 45px">{{member.num}}</td>
									<td style="padding-top: 45px">{{member.name}}</td>
									<td style="padding-top: 45px">{{member.id}}</td>
									<td style="padding-top: 45px">{{member.birthday}}</td>
									<td style="padding-top: 45px">{{member.address}}</td>
									<td style="padding-top: 45px">{{member.addressNum}}</td>
									<td style="padding-top: 45px">{{member.tel}}</td>
									<td style="padding-top: 45px">{{member.register_date}}</td>
									<td style="padding-top: 40px">
										<a href="#/membermodify/{{member.num}}">
											<button class="btn btn-info btn" type="button">
										      <i class='fa fa-pencil'></i>
										    </button>
										</a>
									</td>
									<td style="padding-top: 38px">
										<a href="#/memberdelete/{{member.num}}">
											<button class="btn btn-danger" type="button">
										      <i class='fa fa-trash'></i>
										    </button>
										</a>
									</td>
								</tr>
							</tbody>
							<tr align="center"><td colspan="11">
								<uib-pagination
										data-total-items="paging.totalItem"
										data-ng-model="pageNo"
										data-max-size="1000"
										data-ng-change="selectAdminPage()"
										data-boundary-links="true">
								</uib-pagination>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>