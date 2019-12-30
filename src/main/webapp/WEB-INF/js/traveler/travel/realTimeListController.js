/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("route config...")
		
		$routeProvider.when("/realTimeList", {				//list로 요청을 하면
			templateUrl: "realTimeList.html",				//list.html을 불러와서 ng-view를 호출 
			controller: "realTimeListController"			//listController를 실행
		});
		
	});


	app.controller('realTimeListController', function($scope, $http, $location, URL) {
		console.log("realTimeListController...");
		console.log("URL.GET_PAGE_BASE =" + URL.GET_PAGE_BASE);
		console.log("URL.POST_ITEM_APPEND  =" + URL.POST_ITEM_APPEND);
		
		$scope.$parent.title = "실시간 게시판"; 	//부모 Controller인 mainController가 
													//호출되면서 main.jsp에 있는 title에 바인딩 되면서 화면에 나타난다.
		$scope.pageNo = 1;
		$scope.realTimes = [];
		$scope.paging = {};
		$scope.realTime = {};
		
		$scope.check = function(){
			if($scope.loginId=="master"){
				return true;
			}else{
				return false;
			}
		}
		
		$scope.selectPage = function() {
			$http.get(URL.GET_PAGE_BASE + $scope.pageNo).success(function(data, status, headers, config) {
				console.dir(data);
				$scope.realTimes = data.realTimes;
				$scope.paging = data.paging;
//	 			alert("success...");
			});
		};
		
		$scope.selectPage();
		
		$scope.realTime.real_date = new Date();
		
		$scope.submit = function()
		{
			var ajax = $http.post(URL.POST_ITEM_APPEND,{
				number: $scope.realTime.number,
					id: $scope.member.id,
			   content: $scope.realTime.content,
		     real_date: $scope.realTime.real_date
			});
			
			ajax.then(function (value){
				console.dir(value);
				$scope.selectPage();
				
			}, function(reason){
				 console.dir(reason);	
				});
		};
		
		
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
