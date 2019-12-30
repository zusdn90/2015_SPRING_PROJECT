/**
 * @author java
 */

app.config(function($routeProvider) {
	console.log("/memberdelete config...")
	
	$routeProvider.when("/memberdelete/:num", {
		templateUrl: "memberdelete.html",
		controller: "deleteController"
	});
	
});

app.controller('deleteController', function($scope, $http, URL, $location, $routeParams) {
	console.log("memberdeleteController...");
	console.log("URL.DELETE_ITEM_DELETE_BASE = " + URL.DELETE_ITEM_DELETE_BASE);
	console.log("num = " + $routeParams.num);
	
	var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.num);
	ajax.then(function(value) {
		console.dir(value);
		$scope.member = value.data;
	}, function(reason) {
		console.dir(reason);
		alert("error...");
	});
	
	$scope.submit = function() {
		var ajax = $http.delete(URL.DELETE_ITEM_DELETE_BASE + $scope.member.num);
		
		ajax.then(function(response) {
			console.dir(response.data);
			location.href= "/Traveler/traveler/member/logout"
		}, function(response) {
			console.dir(response.data);
		});
	};
	
});
