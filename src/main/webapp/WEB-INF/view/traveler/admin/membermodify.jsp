<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/common.jspf" %>
<title>membermodify.jsp</title>
<style>
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
.filebox label {
  display: inline-block;
  padding: .5em .75em;
  color: #999;
  font-size: inherit;
  line-height: normal;
  vertical-align: middle;
  background-color: #fdfdfd;
  cursor: pointer;
  border: 1px solid #ebebeb;
  border-bottom-color: #e2e2e2;
  border-radius: .25em;
}

.filebox input[type="file"] {  /* 파일 필드 숨기기 */
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip:rect(0,0,0,0);
  border: 0;
}

.filebox.bs3-success label {
  color: #fff;
  background-color: #5cb85c;
  border-color: #4cae4c;
}
.btn{
	font-weight: bold;
}
 
</style>

</head>
<body class="container">
<div class="row">
<div class="col-sm-6 col-sm-offset-3">
	<div class="panel panel-primary">
		<div class="panel-heading"><font size="4"><b>회원 정보 수정</b></font></div>
		<div class="panel-body">
        <form name="modifyForm" 
        	  id="modifyForm"
        	  novalidate="novalidate" 
        	  method="post" 
        	  enctype="multipart/form-data"
        	  data-ng-submit="submit()" 
        	  >
         <!-- 로그인정보   -->
            <div class="form-group">
				<!-- picture -->
				<label for="memberPicture">사진등록:</label>
				<div style="display: inline;">
					<div align="center">
						<img alt="" ng-src="<c:url value="/img/"/>{{convertMemberPicture()}}" width="150" height="150">
					</div>
					<div class="form-group">
				      <div>
				        <input type="file" 
				        	   multiple 
				        	   class="file"
				        	   name="imageFile"
				        	   id="memberPicture" 
				        	   size="50"
				        	   >
				      </div>
				    </div>
				</div>
				<div data-ng-show="AppendForm.memberPicture.$dirty">
					<div class="alert alert-warning" data-ng-show="AppendForm.memberPicture.$error.required">사진을 등록해 주시기 바랍니다.</div>
					<div class="alert alert-warning" data-ng-show="AppendForm.memberPicture.$error.maxlength">파일명은 최대 15자까지 입력가능합니다.</div>
				</div>
			</div>
            <div class="form-group">
               <label for="id">아이디:</label> 
               <input type="text"
               		  id="id"
                      name="id"    
                      class="form-control" 
                      placeholder="사용할 ID를 입력하세요"
                      required="required"
                      readonly="readonly"
                      data-ng-minlength="4"
                      data-ng-maxlength="12"
                      data-ng-model="member.id"
                      />
                <div data-ng-show="AppendForm.id.$dirty">
					<div class="alert alert-warning" data-ng-show="AppendForm.id.$error.required">필수 입력 항목입니다.</div>
					<div class="alert alert-warning" data-ng-show="AppendForm.id.$error.minlength">최소 4자이상 입력가능합니다.</div>
					<div class="alert alert-warning" data-ng-show="AppendForm.id.$error.maxlength">최대 12자까지 입력가능합니다.</div>
				</div>
            </div>

            <div class="form-group">
               <label for="password">비밀번호:</label> 
               <input type="password"
                      name="password"
                      class="form-control" 
                      id="password"
                      placeholder="비밀번호를 입력하세요"
                      data-ng-minlength="4"
                      data-ng-maxlength="12"
                      required="required"
                      data-ng-model="member.password"/>
              	<div data-ng-show="modifyForm.password.$dirty">
					<div class="alert alert-warning" data-ng-show="modifyForm.password.$error.required">필수 입력 항목입니다.</div>
					<div class="alert alert-warning" data-ng-show="modifyForm.password.$error.minlength">최소 4자이상 입력가능합니다.</div>
					<div class="alert alert-warning" data-ng-show="modifyForm.password.$error.maxlength">최대 12자까지 입력가능합니다.</div>
				</div>
            </div>
         
         	<!-- 개인정보 -->
            <div class="form-group">
               <label for="name">이름:</label> 
               <input type="text"   
                     name="name"
                     class="form-control" 
                     id="name" 
                     placeholder="이름"
                     required="required"
                     data-ng-model="member.name"/>
                     <div data-ng-show="modifyForm.name.$dirty">
						<div class="alert alert-warning" data-ng-show="modifyForm.name.$error.required">필수 입력 항목입니다.</div>
					 </div>
            </div>
            
            <div class="form-group">
               <label for="birthday">생년월일:</label> 
               <div>
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
	                        required="required"
	                        value="우편번호 찾기"/>
	                         <div data-ng-show="modifyForm.birthday.$dirty">
								<div class="alert alert-warning" data-ng-show="modifyForm.birthday.$error.required">필수 입력 항목입니다.</div>
							 </div>
	               </div>
			</div>
			<div class="form-group">
               <label for="addressNum">우편번호:</label> 
               <input type="text"
                      name="addressNum"
                      class="form-control"
                      id="addressNum"
                      required="required"
                      placeholder="우편번호"
                      data-ng-model="member.addressNum"
                      />
                      <div data-ng-show="modifyForm.addressNum.$dirty">
						 <div class="alert alert-warning" data-ng-show="modifyForm.addressNum.$error.required">필수 입력 항목입니다.</div>
					  </div>
                     <br>
                     
               <label for="address">도로명 주소:</label> 
               <input type="text"
                      name="address"
                      class="form-control"
                      id="address"
                      required="required"
                      placeholder="도로명주소"
                      data-ng-model="member.address"
                      />
                      <div data-ng-show="modifyForm.address.$dirty">
						 <div class="alert alert-warning" data-ng-show="modifyForm.address.$error.required">필수 입력 항목입니다.</div>
					  </div>
            </div>
            
            <div class="form-group">
               <label for="tel">연락처:</label> 
               <input type="text"
                     name="tel"
                     class="form-control" 
                     id="tel" 
                     placeholder=" ex) 010-1234-1234 or 02-1234-1234"
                     pattern="\d{2,3}-\d{3,4}-\d{4}"
                     required="required"
                     data-ng-model="member.tel"/>
                     <div data-ng-show="modifyForm.tel.$dirty">
						<div class="alert alert-warning" data-ng-show="modifyForm.tel.$error.required">필수 입력 항목입니다.</div>
					 	<div class="alert alert-warning" data-ng-show="modifyForm.tel.$error.pattern">주어진 형식대로 입력하세요. ex) 010-1234-1234 or 02-1234-1234</div>
					 </div>
            </div>
         	<div class="form-group" align="right">
         	<a href="../traveler/member/main.html">
            <input type="submit"
                   class="btn btn-success"
                   value="완료"
                   data-ng-click="toggle()"
                   data-ng-disabled="modifyForm.$invalid"/>
            </a>
			</div>
		</form>
</div>
</div>
</div>
</div>
</body>
</html>