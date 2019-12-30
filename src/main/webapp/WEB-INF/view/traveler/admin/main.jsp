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
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/common.jspf" %>

<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<title>Main.jsp</title>

<!-- URL Resolve -->
<c:url var="URL_GET_LIST"					value="/traveler/admin/"/>
<c:url var="URL_GET_ITEM_BASE" 				value="/traveler/admin/"/>		
<c:url var="URL_GET_PAGE_BASE" 				value="/traveler/admin/page/"/>	

<c:url var="URL_POST_LIST_APPEND" 			value="/traveler/admin/"/>
<c:url var="URL_POST_ITEM_APPEND" 			value="/traveler/admin/"/>

<c:url var="URL_PUT_LIST_MODIFY" 			value="/traveler/admin/"/>
<c:url var="URL_PUT_ITEM_MODIFY_BASE" 		value="/traveler/admin/"/>		

<c:url var="URL_DELETE_ITEM_DELETE_BASE" 	value="/traveler/admin/"/>	


<script type="text/javascript">

	var urls = {
			
		GET_LIST : 					"${URL_GET_LIST}",
		GET_PAGE_BASE : 			"${URL_GET_PAGE_BASE}",
		GET_ITEM_BASE :				"${URL_GET_ITEM_BASE}",
		
		POST_LIST_APPEND :			"${URL_POST_LIST_APPEND}",
		POST_ITEM_APPEND :			"${URL_POST_ITEM_APPEND}",
		
		PUT_LIST_MODIFY :			"${URL_PUT_LIST_MODIFY}",
		PUT_ITEM_MODIFY_BASE :		"${URL_PUT_ITEM_MODIFY_BASE}",
		
		DELETE_ITEM_DELETE_BASE :	"${URL_DELETE_ITEM_DELETE_BASE}"
	};	
		
	var deps = ['ngRoute',
	            'ngAnimate',
	            'ngTouch',
	            'angular-loading-bar',
	            'ui.bootstrap'
	           ];

	var app = angular.module("travelerApp", deps);
	
	app.config(function($routeProvider) {
		$routeProvider.otherwise({
			redirectTo: "/memberList"
		});
	});
	
	app.constant("URL", urls);
	
	app.controller("mainController", function($scope, $http, $location) {
		
		console.log("mainController...");
	});
	
</script>

<c:url var="listController"   value="/js/traveler/admin/listController.js"/>
<c:url var="appendController" value="/js/traveler/admin/appendController.js"/>
<c:url var="modifyController" value="/js/traveler/admin/modifyController.js"/>
<c:url var="deleteController" value="/js/traveler/admin/deleteController.js"/>

<script type="text/javascript" src="${listController}"></script>
<script type="text/javascript" src="${appendController}"></script>
<script type="text/javascript" src="${modifyController}"></script>
<script type="text/javascript" src="${deleteController}"></script>

</head>
<body class="container">
<div data-ng-view>

</div>
</body>
</html>