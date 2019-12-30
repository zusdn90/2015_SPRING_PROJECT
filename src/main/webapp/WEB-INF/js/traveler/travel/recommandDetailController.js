/**
 * @author java
 */

app.config(function($routeProvider) {
	console.log("/recommandDetail config...")
	
	$routeProvider.when("/recommandDetail/:listNo", {
		templateUrl: "recommandDetail.html",
		controller: "detailController"
	});
	
});


app.controller('detailController', function($scope, $http, URL, $routeParams, $location) {
	console.log("detailController...");
	console.log("URL.GET_ITEM_BASE = " + URL.GET_ITEM_BASE);
	console.log("listNo = " + $routeParams.listNo);

	$scope.$parent.title = "detail Recommand View";
	
	$scope.cancel = function(){
		$location.path("/recommandList");
	}

	
	$scope.commentLists=[];
	$scope.recommand={};
	$scope.content={};
	$scope.member = {};
	
	
	$scope.aaa = function(){ 
	var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.listNo); 
	ajax.then(function(value) {
		console.dir(value);
		$scope.recommand = value.data;
		
	}, function(reason) {
		console.dir(reason);
		alert("error...");
	});
	};
	
	$scope.aaa();
	
	$scope.c = function(){
		if($scope.loginId=="master"){
			return true;
		}else{
			return false;
		}
	}
	
	
	$scope.click = function(){
		var ajax = $http.post(URL.PUT_ITEM_MODIFY_BASE + $scope.recommand.listNo , {
			listNo   : $scope.recommand.listNo,
			id 		 : $scope.loginId,
			content  : $scope.content.content,
		});
		
		ajax.then(function(value) {
			$scope.aaa();
		}, function(reason) {
			$scope.recommand = reason.data;
		});
	};

});
