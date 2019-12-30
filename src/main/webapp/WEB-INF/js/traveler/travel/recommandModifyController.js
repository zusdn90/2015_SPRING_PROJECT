/**
 * @author java
 */

app.config(function($routeProvider) {
	console.log("/recommandModify config...")
	
	$routeProvider.when("/recommandModify/:listNo", {
		templateUrl: "recommandModify.html",
		controller: "modifyController"
	});
	
});


app.controller('modifyController', function($scope, $http, URL, $routeParams, $location) {
	console.log("modifyController...");
	console.log("URL.PUT_ITEM_MODIFY_BASE = " + URL.PUT_ITEM_MODIFY_BASE);
	console.log("URL.GET_ITEM_BASE = " + URL.GET_ITEM_BASE);
	console.log("listNo = " + $routeParams.listNo);

	$scope.$parent.title = "MODIFY Recommand View";
	
	var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.listNo); 
	ajax.then(function(value) {
		console.dir(value);
		$scope.recommand = value.data;
	}, function(reason) {
		console.dir(reasone);
		alert("error...");
	});
	
	$scope.radio = function() { 
		var r = $('input:radio[name="area"]:checked').val();
		$scope.recommand.area = r;
	};
	
	$scope.cancel = function(){
		$location.path("/recommandList");
	}
		
	   $scope.toggle = function() {
	       var p = $('#picture').val();
	       $scope.recommand.picture = p;
	    };
	
	$scope.submit = function(){
		var ajax = $http.put(URL.PUT_ITEM_MODIFY_BASE + $scope.recommand.listNo , {
			title   : $scope.recommand.title,
			area 	: $scope.recommand.area,
			name    : $scope.recommand.name,
			content : $scope.recommand.content,
			picture : $scope.recommand.picture
		});
		
		ajax.then(function(value) {
			$location.path("/recommandList");
		}, function(reason) {
			$scope.recommand = reason.data;
		});
	};

});
