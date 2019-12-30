/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("/realTimeDelete config...")
		
		$routeProvider.when("/realTimeDelete/:number", {				//delete로 요청을 하면
			templateUrl: "realTimeDelete.html",				//delete.html을 불러와서 ng-view를 호출 
			controller: "realTimeDeleteController"			//deleteController를 실행
		});
		
	});


app.controller('realTimeDeleteController', function($scope, $http, URL, $routeParams) {
		console.log("realTimeDeleteController...");
		console.log("URL.DELETE_ITEM_DELETE_BASE =" + URL.DELETE_ITEM_DELETE_BASE);
		console.log("number = " + $routeParams.number);
		$scope.$parent.title = "Delete realTime View";		
		
		var ajax = $http.delete(URL.DELETE_ITEM_DELETE_BASE+ $routeParams.number);
			
		ajax.then(function() {
			$scope.$parent.title = "삭제 성공";
		}, function() {
			$scope.$parent.title = "삭제 실패";
		});
		
	});
