/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("route config...")
		
		$routeProvider.when("/shareList", {				//list로 요청을 하면
			templateUrl: "shareList.html",				//list.html을 불러와서 ng-view를 호출 
			controller: "listController"			//listController를 실행
		});
		
	});


	app.controller('listController', function($scope, $http, URL) {
		console.log("listController...");
		console.log("URL.GET_PAGE_BASE =" + URL.GET_PAGE_BASE);
		
		$scope.pageNo = 1;
		$scope.shares = [];
		$scope.paging = {};
		
		
		
		
		$scope.selectPage = function() {
			$http.get(URL.GET_PAGE_BASE + $scope.pageNo).success(function(data, status, headers, config) {
				console.dir(data);
				$scope.shares = data.shares;
				$scope.loginstatus = value.data.login;
				$scope.paging = data.paging;
//	 			alert("success...");
			});
		};
		

		$scope.check = function(){
			if($scope.loginId=="master"){
				return true;
			}else{
				return false;
			}
		}
		
		
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
