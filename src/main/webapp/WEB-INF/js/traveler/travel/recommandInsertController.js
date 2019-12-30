/**
 * @author java
 */

app.config(function($routeProvider) {
	console.log("/recommandInsert config...")
	
	$routeProvider.when("/recommandInsert", {
		templateUrl: "recommandInsert.html",
		controller: "appendController"
	});
	
});


app.controller('appendController', function($scope, $http, $location, URL) {
	console.log("appendController...");
	console.log("URL.POST_ITEM_APPEND = " + URL.POST_ITEM_APPEND);
	
	$scope.$parent.title = "Append Recommand View";
	$scope.master = "관리자";
	
//	$("#picture").fileinput({
//		uploadUrl : "../img",
//		uploadAsync : true,
//		maxFileCount : 1,
//	    allowedFileExtensions: ["jpg", "png", "gif"],
//	    minImageWidth: 50,
//	    minImageHeight: 50
//	});
	
	

	$scope.cancel = function(){
		$location.path("/recommandList");
	}
	
	$scope.recommand = {};
	
	$scope.radio = function() { 
		var r = $('input:radio[name="area"]:checked').val();
		$scope.recommand.area = r;
	};
	
		
	   $scope.toggle = function() {
	       var p = $('#picture').val();
	       $scope.recommand.picture = p;
	    };
	
	$scope.submit = function(){
		var ajax = $http.post(URL.POST_ITEM_APPEND,{
			title   : $scope.recommand.title,
			area 	: $scope.recommand.area,
			name    : $scope.master,
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
