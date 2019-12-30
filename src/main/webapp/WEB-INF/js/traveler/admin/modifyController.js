/**
 * @author java
 */

app.config(function($routeProvider) {
	console.log("/membermodify config...")
	
	$routeProvider.when("/membermodify/:num", {
		templateUrl: "membermodify.html",
		controller: "modifyController"
	});
	
});

app.controller('modifyController', function($scope, $http, URL, $routeParams, $location) {
	console.log("modifyController...");
	console.log("URL.PUT_ITEM_MODIFY_BASE = " + URL.PUT_ITEM_MODIFY_BASE);
	console.log("URL.GET_ITEM_BASE = " + URL.GET_ITEM_BASE);
	console.log("id = " + $routeParams.id);

	var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.id);
	console.log("num = " + $routeParams.num);
	
	$scope.toggle = function(){
		var p = $('#memberPicture').val();
		$scope.member.memberPicture = p;
		alert("수정 성공");
	};
	
	$scope.$parent.title = "회원 정보 수정";
	var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.num);
	ajax.then(function(value) {
		console.dir(value);
		$scope.member = value.data;
	}, function(reason) {
		console.dir(reason);
		alert("error...");
	});
	
	$scope.today = function() {
	    $scope.dt = new Date();
	  };
	  $scope.today();

	  $scope.clear = function () {
	    $scope.dt = null;
	  };

	  // Disable weekend selection
	  $scope.disabled = function(date, mode) {
	    return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
	  };
	  
	  $scope.maxDate = new Date(2020, 5, 22);

	  $scope.open = function($event) {
	    $scope.status.opened = true;
	  };

	  $scope.setDate = function(year, month, day) {
	    $scope.dt = new Date(year, month, day);
	  };

	  $scope.dateOptions = {
	    formatYear: 'yy',
	    startingDay: 1
	  };

	  $scope.formats = 'yyyy-MM-dd';
	  $scope.format = $scope.formats[0];

	  $scope.status = {
	    opened: false
	  };

	  var tomorrow = new Date();
	  tomorrow.setDate(tomorrow.getDate() + 1);
	  
	  var afterTomorrow = new Date();
	  afterTomorrow.setDate(tomorrow.getDate() + 2);
	  
	  $scope.events =
	    [
	      {
	        date: tomorrow,
	        status: 'full'
	      },
	      {
	        date: afterTomorrow,
	        status: 'partially'
	      }
	    ];

	  $scope.getDayClass = function(date, mode) {
	    if (mode === 'day') {
	      var dayToCheck = new Date(date).setHours(0,0,0,0);

	      for (var i=0;i<$scope.events.length;i++){
	        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

	        if (dayToCheck === currentDay) {
	          return $scope.events[i].status;
	        }
	      }
	    }

	    return '';
	};

	$scope.convertMemberPicture = function() {
		var name = $scope.member.memberPicture;
		var pos = name.lastIndexOf("\\");
		name = name.substr(pos + 1, name.length);
		$scope.member.memberPicture = name;
		return $scope.member.memberPicture;
	};
	
	$scope.submit = function() {
		var ajax = $http.put(URL.PUT_ITEM_MODIFY_BASE + $scope.member.num, {
			memberPicture:  $scope.member.memberPicture,
			num : 			$scope.member.num,
			id : 			$scope.member.id,
			password : 		$scope.member.password,
			name : 			$scope.member.name,
			register_date : $scope.member.register_date,
			birthday : 		$scope.member.birthday,
			tel : 			$scope.member.tel,
			address : 		$scope.member.address,
			addressNum : 	$scope.member.addressNum
		});
		
		ajax.then(function(response) {
			console.dir(response.data);
			location.href= "/Traveler/traveler/member/memberMain.html";
		}, function(response) {
			console.dir(response.data);
		});
	};
	

	
    $scope.adsSystem = function () {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
//                document.getElementById('addressNum').value = data.zonecode; //5자리 새우편번호 사용
//                document.getElementById('address').value = fullRoadAddr;
                $scope.member.addressNum = data.zonecode;
                $scope.member.address = fullRoadAddr;
                $scope.$apply(); // 다른 모델에서 참조할때는 $scope.$apply();가 있어야 추가 가능.

            }
        }).open({
        	 autoClose: true
        });
    }
	
	
	
	
});
