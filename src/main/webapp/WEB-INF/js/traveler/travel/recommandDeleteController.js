/**
 * @author java
 */

app.config(function($routeProvider) {
	console.log("/recommandDelete config...")
	
	$routeProvider.when("/recommandDelete/:listNo", {
		templateUrl: "recommandDelete.html",
		controller: "deleteController"
	});
	
});


app.controller('deleteController', function($scope, $http, URL, $routeParams, $location) {
	console.log("deleteController...");
	console.log("URL.DELETE_ITEM_DELETE_BASE = " + URL.DELETE_ITEM_DELETE_BASE);
	console.log("name = " + $routeParams.listNo);

	$scope.$parent.title = "Delete Recommand View";
	
	$scope.back = function(){
		$location.path("/recommandList");
	}

	
	
	var ajax = $http.delete(URL.DELETE_ITEM_DELETE_BASE + $routeParams.listNo); // /city/2000
	ajax.then(function(value) {
		console.dir(value);
	}, function(reason) {
		console.dir(reasone);
		alert("error...");
	});
	

});
