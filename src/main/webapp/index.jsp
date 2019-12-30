<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>index.jsp</title>
<style type="text/css">

	.title_animation {
		animation : blink 2s infinite;
	}
	
	@keyframes blink {
		from {
			background-color : black;
			opacity : 0.0;
		}
		to {
			background-color : red;
			opacity : 1.0;
		}
	}
	

</style>
</head>
<body>
<h1 class="title_animation">traveler</h1>


</body>
</html>