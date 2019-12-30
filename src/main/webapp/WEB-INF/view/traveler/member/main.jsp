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

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Traveler</title>
<script src="http://maps.google.com/maps/api/js"></script>
<script type="text/javascript">
var deps = ['ngRoute',
            'ngAnimate',
            'ngTouch',
            'angular-loading-bar',
            'ui.bootstrap',
            'ngMap'
           ];

var app = angular.module("travelerApp", deps);


app.controller("mainController", function($scope, $http, $location) {
	console.log("mainController...");
	
});

</script>

<script>
//구글맵, 애니메이션, 마커, 텍스트
var myCenter = new google.maps.LatLng(37.499538, 127.030520);
var marker;

function initialize()
{
	var mapProp = {
	  center:myCenter,
	  zoom:17, 
	  mapTypeId:google.maps.MapTypeId.ROADMAP
	  };
	
	var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
	
	var marker=new google.maps.Marker({
	  position:myCenter,
	  animation:google.maps.Animation.BOUNCE
	  });
	
	var infowindow = new google.maps.InfoWindow({
		  content:"중앙정보인재기술개발원"
		  });

		infowindow.open(map,marker);
		
	
	marker.setMap(map);
	
	

}

google.maps.event.addDomListener(window, 'load', initialize);

</script>

<style type="text/css">

#map
{
	height : 400px;
}

</style>

<!-- Bootstrap Core CSS -->
<link href="/Traveler/mainbootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/Traveler/mainbootstrap/css/stylish-portfolio.css" rel="stylesheet">


<!-- Custom Fonts -->
<link href="/Traveler/mainbootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

</head>

<body data-ng-controller="mainController">
    <!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center">
            <h1>Traveler</h1>
            <h3></h3>
            <br>
            <a href="#about" class="btn btn-dark btn-lg">Find Out More</a>
        </div>
    </header>
    
    <!-- About -->
    <section id="about" class="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>신나는 여행정보 공유 사이트 Traveler!!</h2>
                    <p class="lead">여러분의 여행장소와 소중한 추억들을 공유해주세요.</p>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </section>

    <!-- Services -->
    <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
    <section id="services" class="services bg-primary">
        <div class="container">
            <div class="row text-center">
                <div class="col-lg-10 col-lg-offset-1">
                    <h2>Our Services</h2>
                    <hr class="small">
                    <div class="row">
                        <div class="col-md-4 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-cloud fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>추천 여행지</strong>
                                </h4>
                                <p>사이트에서 추천하는 여행지</p>
                                <a href="<c:url value="/traveler/recommand/recommandMain.html"/>" class="btn btn-light">추천 여행지 게시판</a>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-compass fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>여행 정보 공유</strong>
                                </h4>
                                <p>여행 정보를 공유해보세요</p>
                                <a href="<c:url value="/traveler/travel/shareMain.html"/>" class="btn btn-light">여행 정보 공유 게시판</a>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-comment fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>실시간 게시판</strong>
                                </h4>
                                <p>여행 실시간 게시판</p>
                                <a href="<c:url value="/traveler/realTime/realTimeMain.html"/>" class="btn btn-light">실시간 게시판</a>
                            </div>
                        </div>
                    </div>
                    <!-- /.row (nested) -->
                </div>
                <!-- /.col-lg-10 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </section>

    <!-- Callout -->
    <aside class="">
        <div class="">
            <img alt="" src="/Traveler/img/풍경.jpg" class="img-responsive">
        </div>
    </aside>

    <!-- Portfolio -->
    <section id="portfolio" class="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1 text-center">
                     <h2><a href="../recommand/recommandMain.html" class="btn btn-info btn-lg"><b>추천여행지</b></a></h2>
                    <hr class="small">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="portfolio-item">
                                <a href="../recommand/recommandMain.html#/recommandDetail/43">
                                    <img class="img-portfolio img-responsive" src="/Traveler/img/제주도_마방목지.jpg" data-toggle="tooltip" title="제주도 마방목지" data-placement="top">
                                </a>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="portfolio-item">
                                <a href="../recommand/recommandMain.html#/recommandDetail/44">
                                    <img class="img-portfolio img-responsive" src="/Traveler/img/수월봉_001.png" data-toggle="tooltip" title="제주도 수월봉" data-placement="top">
                                </a>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="portfolio-item">
                                <a href="../recommand/recommandMain.html#/recommandDetail/46">
                                    <img class="img-portfolio img-responsive" src="/Traveler/img/연동어촌체험마을.jpg" data-toggle="tooltip" title="전라남도 월출봉" data-placement="top">
                                </a>
                            </div>
                        </div>
             
                        <div class="col-md-6">
                            <div class="portfolio-item">
                                <a href="../recommand/recommandMain.html#/recommandDetail/45">
                                    <img class="img-portfolio img-responsive" src="/Traveler/img/향가유원지.png" data-toggle="tooltip" title="전라남도 월출봉" data-placement="top">
                                </a>
                            </div>
                        </div>
             
                    </div>
                    <!-- /.row (nested) -->
                    
                </div>
                <!-- /.col-lg-10 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </section>
    
      <!-- Map -->
		<div class="container" id="googleMap"  style="width:950px; height:380px;"></div>

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1 text-center">
                    <h4><strong><font color="337ab7">Traveler</font></strong>
                    </h4>
                    <p>서울특별시 강남구 테헤란로 7길 7<br>(역삼동 에스코빌딩 6층)</p>
                    <ul class="list-unstyled">
                        <li><i class="fa fa-phone fa-fw"></i> (02) 561-1911</li>
                        <li><i class="fa fa-envelope-o fa-fw"></i>  <a href="mailto:infoprotect@choongang.co.kr">infoprotect@choongang.co.kr</a>
                        </li>
                    </ul>
                    <br>
                    <ul class="list-inline">
                        <li>
                            <a href="#"><i class="fa fa-facebook fa-fw fa-3x"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter fa-fw fa-3x"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-dribbble fa-fw fa-3x"></i></a>
                        </li>
                    </ul>
                    <hr class="small">
                    <p class="text-muted">Copyright &copy; Your Website 2016</p>
                </div>
            </div>
        </div>
    </footer>
</body>

</html>
