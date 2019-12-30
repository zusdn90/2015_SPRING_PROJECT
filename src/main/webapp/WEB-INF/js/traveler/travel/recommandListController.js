/**
 * @author java
 */
app.config(function($routeProvider) {

		console.log("/recommandList config...")
		
		$routeProvider.when("/recommandList", {
			templateUrl: "recommandList.html",
			controller: "recommandListController"
		});
});

app.controller('recommandListController', function($scope, $http, URL) {
	console.log("recommandListController...");
	console.log("URL.GET_PAGE_BASE = " + URL.GET_PAGE_BASE);
	
	$scope.$parent.title = "추천게시판";
	
	$scope.pageNo = 1;
	$scope.recommandLists = [];
	$scope.paging = {};
	
	$scope.c = function(){
		if($scope.loginId=="master"){
			return true;
		}else{
			return false;
		}
	}
	
	
	$scope.selectPage = function() {
		$http.get(URL.GET_PAGE_BASE + $scope.pageNo).success(function(data, status, headers, config) {
			console.dir(data);
			$scope.recommandLists = data.recommandLists;
			$scope.paging = data.paging;
		});
	};
	
	$scope.selectPage();
	
		
	
		$scope.prevClick = function(pageNo) {
			console.log("prevClick()... pageNo = " + pageNo);
			$scope.pageNo = pageNo
			$scope.selectPage();
// 			alert("pageNo=" + pageNo);
		};
		
		$scope.pageClick = function(pageNo) {
			console.log("pageClick()... pageNo = " + pageNo);
			$scope.pageNo = pageNo
			$scope.selectPage();
// 			alert("pageNo=" + pageNo);
		};
		
		$scope.nextClick = function(pageNo) {
			console.log("nextClick()... pageNo = " + pageNo);
			$scope.pageNo = pageNo
			$scope.selectPage();
// 			alert("pageNo=" + pageNo);
		};
		
});