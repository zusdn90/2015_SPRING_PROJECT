/**
 * @author java
 */

app.config(function($routeProvider) {
	console.log("/memberList config...")
	
	$routeProvider.when("/memberList", {
		templateUrl: "memberList.html",
		controller: "listController"
	});
});

app.controller('listController', function($scope, $http, URL, $location, $routeParams) {
	console.log("listController...");
	console.log("URL.GET_PAGE_BASE = " + URL.GET_PAGE_BASE);

	$scope.pageNo = 1;
	$scope.members = [];
	$scope.pagination = {};
	
	$scope.c = function(){
		if($scope.loginId=="master"){
			return true;
		}else{
			return false;
		}
	}
	
	$scope.selectAdminPage = function() {
		$http.get(URL.GET_PAGE_BASE + $scope.pageNo).success(function(data, status, headers, config) {
			console.dir(data);
			$scope.members = data.members;
			$scope.pagination = 
				data.pagination;
//	 			alert("success...");
		});
	};

	$scope.selectAdminPage();
	
	$scope.prevClick = function(pageNo) {
		console.log("prevClick()... pageNo = " + pageNo);
		$scope.pageNo = pageNo
		$scope.selectAdminPage();
//			alert("pageNo=" + pageNo);
	};
	
	$scope.pageClick = function(pageNo) {
		console.log("pageClick()... pageNo = " + pageNo);
		$scope.pageNo = pageNo
		$scope.selectAdminPage();
//			alert("pageNo=" + pageNo);
	};
	
	$scope.nextClick = function(pageNo) {
		console.log("nextClick()... pageNo = " + pageNo);
		$scope.pageNo = pageNo
		$scope.selectAdminPage();
//			alert("pageNo=" + pageNo);
	};

});
