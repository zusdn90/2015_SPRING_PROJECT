/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("/detail config...")
		
		$routeProvider.when("/realTimeDetail/:number", {				//detail로 요청을 하면
			templateUrl: "realTimeDetail.html",				//detail.html을 불러와서 ng-view를 호출 
			controller: "realTimeDetailController"			//detailController를 실행
		});
		
	});


	app.controller('realTimeDetailController', function($scope, $http, URL, $routeParams) {
		console.log("realTimeDetailController...");
		console.log("URL.GET_ITEM_BASE =" + URL.GET_ITEM_BASE);
		console.log("number = " + $routeParams.number);
		
		$scope.$parent.title = "상세정보";		
		
		var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.number);	//ajax를 이용하여 페이지 호출
		
		ajax.then(function(value) {			//ajax if문 표현 
			console.dir(value);
			$scope.realTime = value.data;		//model에 binding이 자동으로 된다.	
		}, function(reason) {
			console.dir(reason);
			alert("error...");
		});
	});
