/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("/insert config...")
		
		$routeProvider.when("/shareInsert", {				
			templateUrl: "shareInsert.html",				
			controller: "shareController"			
		});
		
	});


	app.controller('shareController', function($scope, $http, $location, URL) {
		console.log("shareController...");
		console.log("URL.POST_ITEM_APPEND =" + URL.POST_ITEM_APPEND);
		
		$scope.$parent.title = "게시글 작성";		
		$scope.share={};
	
		
		$scope.toggle = function(){
			var p = $('#picture').val();
			$scope.share.picture = p;
			$scope.getTotal();
		};
		
		$scope.getTotal = function()
		{
			var gt = $scope.share.transCost+$scope.share.stayCost+$scope.share.eatCost;
			$scope.share.totalCost = gt;
		}
		
		$scope.convertMemberPicture = function() {
			var name = $scope.member.memberPicture;
			var pos = name.lastIndexOf("\\");
			name = name.substr(pos + 1, name.length);
			$scope.member.memberPicture = name;
			return $scope.member.memberPicture;
		};
		
		$scope.submit = function()
		{
			var ajax = $http.post(URL.POST_ITEM_APPEND,{
				id : $scope.member.id,
				writer: $scope.member.name,
				title : $scope.share.title,
				term : $scope.share.term,
				number : $scope.share.number,
				eatCost : $scope.share.eatCost,
				stayCost : $scope.share.stayCost,
				transCost : $scope.share.transCost,
				totalCost : $scope.share.totalCost,
				content : $scope.share.content,
				picture : $scope.share.picture,
				map : $scope.share.map,
				memberPicture : $scope.member.memberPicture,
				tel : $scope.member.tel,
				birthday : $scope.member.birthday
			});
			
			
			ajax.then(function(value) {				//성공시
				$location.path("/shareList");
			}, function(reason) {					//에러시
				$scope.share = reason.data;
				alert("에러");
			});
		};
	});

