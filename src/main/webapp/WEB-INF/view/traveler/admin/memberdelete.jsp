<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta charset="UTF-8">
<head>
<title>delete.jsp</title>
<style>
  button{
  	font-weight: bold;
  }
  .full button span {
    background-color: limegreen;
    border-radius: 32px;
    color: black;
  }
  .partially button span {
    background-color: orange;
    border-radius: 32px;
    color: black;
  }
  .btn{
	font-weight: bold;
  }
</style>
</head>
<body class="container">
<div class="row">
<div class="col-sm-8 col-sm-offset-2">
	<div class="panel panel-primary">
		<div class="panel-heading">회원 탈퇴</div>
		<div class="panel-body">
		<div align="center">
			<input type="button"
                   class="btn btn-primary btn-lg btn-block"
                   value="정말 탈퇴 하시겠습니까?"
                   />
		</div>
        <form name="deleteForm" novalidate="novalidate" data-ng-submit="submit()">
          <!-- 로그인정보   -->
          	<div class="form-group" align="center">
          		<img alt="" src="${pageContext.request.contextPath}/img/{{member.memberPicture}}" width="150" height="150">
          	</div>
            <div class="form-group">
               <label for="id">아이디:</label> 
               <input type="text"
               		  id="id"
                      name="id"    
                      class="form-control" 
                      placeholder="사용할 ID를 입력하세요"
                      readonly="readonly"
                      data-ng-model="member.id"/>
            </div>
            
            <div class="form-group">
               <label for="password">비밀번호:</label> 
               <input type="password"
                      name="password"
                      class="form-control"
                      id="password"
                      readonly="readonly"
                      placeholder="비밀번호를 입력하세요"
                      data-ng-model="member.password"/>
            </div>
         
         	<!-- 개인정보 -->
            <div class="form-group">
               <label for="name">이름:</label> 
               <input type="text"   
                     name="name"
                     class="form-control" 
                     id="name" 
                     readonly="readonly"
                     placeholder="이름"
                     data-ng-model="member.name"/>
            </div>
            
            <div class="form-group">
               <label for="birthday">생년월일:</label> 
               <div align="right">
              		<input  type="text"
              				id="birthday"
              				name="birthday"
              				class="form-control" 
              				uib-datepicker-popup 
              				data-ng-model="member.birthday"
              				is-open="status.opened" 
              				max-date="maxDate"
              				datepicker-options="dateOptions" 
              				date-disabled="disabled(date, mode)" 
              				ng-required="true" 
              				close-text="Close"
              				readonly="readonly"
              				/>
              		<span class="input-group-btn">
                		<button type="button" class="btn btn-default" ng-click="open($event)"><i class="glyphicon glyphicon-calendar"></i></button>
              		</span>
       			</div>
            </div>
         
            <div class="form-group">
               <label for="adsSystem">주소</label> <p>
	               <div align="right">
	                  <input type="button"
	                        class="btn btn-primary"
	                        data-ng-click="adsSystem()" 
	                        value="우편번호 찾기"
	                        readonly="readonly"
	                        />
	               </div>
			</div>
			<div class="form-group">
               <label for="addressNum">우편번호:</label> 
               <input type="text"
                      name="addressNum"
                      class="form-control"
                      id="addressNum"
                      readonly="readonly"
                      placeholder="우편번호"
                      data-ng-model="member.addressNum"
                      />
                     <br>
                     
               <label for="address">도로명 주소:</label> 
               <input type="text"
                      name="address"
                      class="form-control"
                      id="address"
                      placeholder="도로명주소"
                      readonly="readonly"
                      data-ng-model="member.address"
                      />
            </div>
            
            <div class="form-group">
               <label for="tel">연락처:</label> 
               <input type="text"
                     name="tel"
                     class="form-control" 
                     id="tel"
                     readonly="readonly"
                     data-ng-model="member.tel"/>
            </div>
         	<div class="form-group" align="right">
            <input type="submit"
                   class="btn btn-success"
                   value="확인"
                   data-ng-disabled="deleteForm.$invalid"/>
            <a href="../member/memberMain.html">
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
</body>
</html>




