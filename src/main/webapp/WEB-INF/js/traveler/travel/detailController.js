/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("/detail config...")
		
		$routeProvider.when("/shareDetail/:boardNum", {				//detail로 요청을 하면
			templateUrl: "shareDetail.html",				//detail.html을 불러와서 ng-view를 호출 
			controller: "detailController"			//detailController를 실행
		});
		
	});

	app.controller('detailController', function($scope, $http, URL, $routeParams) {
		console.log("detailController...");
		console.log("URL.GET_ITEM_BASE =" + URL.GET_ITEM_BASE);
		console.log("boardNum = " + $routeParams.boardNum);
		
		$scope.$parent.title = "상세정보";		
		
		$scope.content=[];
		
		$scope.convertMemberPicture = function() {
			var name = $scope.member.memberPicture;
			var pos = name.lastIndexOf("\\");
			name = name.substr(pos + 1, name.length);
			$scope.member.memberPicture = name;
			return $scope.member.memberPicture;
		};
		
		$scope.aaa = function(){
		var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.boardNum);	//ajax를 이용하여 페이지 호출
		
		ajax.then(function(value) {			//ajax if문 표현 
			console.dir(value);
			$scope.share = value.data;		//model에 binding이 자동으로 된다.
			$scope.content = $scope.share.contents;
		}, function(reason) {
			console.dir(reason);
			alert("error...");
		});
		};
		
		
		$scope.aaa();
		
		$scope.click = function(){
			var ajax = $http.post(URL.PUT_ITEM_MODIFY_BASE + $scope.share.boardNum , {
				listNo   : $scope.share.boardNum,
				id 		 : $scope.member.id,
				content  : $scope.content.content
			});
			
			ajax.then(function(value) {
				$scope.aaa();
			}, function(reason) {
				$scope.recommand = reason.data;
			});
		};

		
	});
