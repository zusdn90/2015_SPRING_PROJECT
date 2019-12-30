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
<title>recommandModify.jsp</title>
<style type="text/css">
.btn{
	font-weight: bold;
}
</style>
</head>
<body class="container">
<hr>
<div align="center">
	<font color="#337ab7" style="" size="30" face="한컴 소망 B">삭제 되었습니다!</font>
</div>
<hr>
<div align="center">
<a href="#/recommandList">
<button type="button" class="btn btn-primary">게시판으로 돌아가기</button>
</a>
</div>
<hr>
</body>
</html>