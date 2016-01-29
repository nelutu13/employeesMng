
	var app = angular.module("employeesMngApp");

	var UserController = function($scope, $getUsersServ, PageDataService) {

	    var onUserComplete = function(data) {
	        $scope.users = data;
	    };
	
		var onError = function(response) {
		    $scope.error = "Could not get the user list";
		};
		  
		
		$scope.getKeysOfCollection = function(obj) {
		    obj = angular.copy(obj);
		    if (!obj) {
		      return [];
		    }
		    return Object.keys(obj);
		}

		$scope.predicate='name';
		$scope.reverse=false;
		
		$scope.getOrder = function() {}
		$scope.updatePredicate = function(key) {
			$scope.predicate = key;
			$scope.reverse = !$scope.reverse;
		}
	    
		$scope.sortOrder = "-name";
	    $getUsersServ.getUsers().then(onUserComplete, onError);
	    
	    PageDataService.setPageDescription("Manage Users");
	    PageDataService.setPage("users");

	};

	app.controller("UserController", UserController);

