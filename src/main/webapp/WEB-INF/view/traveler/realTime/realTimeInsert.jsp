<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<!DOCTYPE html>
<html lang="ko" data-ng-app="travelerApp">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>realTimeInsert.jsp</title>
</head>
<body class="container" data-ng-controller="realTimeInsertController">
<div class="form-group">
<div class="panel panel-default">
<div class="panel-heading"><b>실시간 내용</b></div>
<div class="panel-body">
<form name="realTimeForm" id="realTimeForm" novalidate="novalidate" data-ng-submit="submit()">
		<textarea rows="5" class="form-control" id="content" name="content" 
				data-ng-model="realTime.content"
				required="required">
		</textarea>
				<div class="form-group">
							<label class="col-sm-2 control-label" for="date"></label>
							<div>
								<input id="reg_date" name="reg_date" type="date" class="form-control"
									required="required" data-ng-model="realTime.reg_date"/>
							</div>
					</div>
<br>
	<!-- Submit -->
	<div class="form-group" align="center">
		<input type="submit" value="등록" class="btn btn-primary"
		data-ng-show="loginstatus"
		data-ng-disabled="realTimeForm.$invalid"  />
	</div>
</form>
</div>
</div>
</div>

</body>
</html>