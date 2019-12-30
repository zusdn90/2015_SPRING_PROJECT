/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("/shareDelete config...")
		
		$routeProvider.when("/shareDelete/:boardNum", {				//delete로 요청을 하면
			templateUrl: "shareDelete.html",				//delete.html을 불러와서 ng-view를 호출 
			controller: "shareDeleteController"			//deleteController를 실행
		});
		
	});


app.controller('shareDeleteController', function($scope, $http, URL, $routeParams) {
		console.log("shareDeleteController...");
		console.log("URL.DELETE_ITEM_DELETE_BASE =" + URL.DELETE_ITEM_DELETE_BASE);
		console.log("boardNum = " + $routeParams.boardNum);
		$scope.$parent.title = "Delete Share View";		
		
		var ajax = $http.delete(URL.DELETE_ITEM_DELETE_BASE+ $routeParams.boardNum);
			
		ajax.then(function() {
			$scope.$parent.title = "삭제 성공";
		}, function() {
			$scope.$parent.title = "삭제 실패";
		});
		
	});
