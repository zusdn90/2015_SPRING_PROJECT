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
<%@ include file="/WEB-INF/view/common.jspf"%>
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
		<i class="fa fa-map-marker fa-5x text-primary"></i>&nbsp; <font
			color="#337ab7" style="" size="30" face="한컴 소망 B">추천 여행지</font>
	</div>
	<hr>
	<div align="center">
		<a  data-ng-show="c()" href="#/recommandInsert"
			class="btn btn-primary btn-block"><font size="5"
			face="한컴 윤고딕 250">글쓰기</font></a>
	</div>
	<hr>
	<div class="row row-offcanvas row-offcanvas-right">
		<div class="col-sm-11">
			<p class="pull-right visible-sm">
				<button type="button" class="btn btn-primary btn-sm"
					data-toggle="offcanvas">Toggle nav</button>
			</p>
			<div class="row" align="center">
				<div class="col-sm-3 col-sm-offset-1"
					 data-ng-repeat="recommand in recommandLists">
					<div class="panel panel-primary">
					<div class="panel-heading">
                        <a style="color: white"
							href="#/recommandDetail/{{recommand.listNo}}"><b>{{recommand.title}}</b>
                    </div>
                    <div class="panel-body">
                            <p><img alt="" src="../../img/{{recommand.picture}}" width="235"
							height="230"></p>
                    </div>
                    </a>
                    </div>
				</div>
			</div>
		</div>
	</div>


	<div align="center">
		<uib-pagination data-total-items="paging.totalItem"
			data-ng-model="pageNo" data-max-size="10"
			data-ng-change="selectPage()" data-boundary-links="true">
		</uib-pagination>
	</div>
	<hr>


</body>
</html>