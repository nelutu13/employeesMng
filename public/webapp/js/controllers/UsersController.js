var module = angular.module("employeesMngApp");

module.controller("UsersController", function($scope, $state, UsersService) {

	UsersService.initUsers();

	$scope.getUsers = UsersService.getUsers;
	$scope.getError = UsersService.getError;
	$scope.goToUsersDetail = UsersService.goToUsersDetail;
	
	$scope.getKeysOfCollection = UsersService.getKeysOfCollection;
	
	$scope.predicate='name';
	$scope.reverse=false;
	$scope.getOrder = function() {}
	$scope.updatePredicate = function(key) {
		$scope.predicate = key;
		$scope.reverse = !$scope.reverse;
	}
	$scope.sortOrder = "-name";

});



module.controller("UsersDetailController", function($scope, $stateParams, UsersDetailService) {
	
	UsersDetailService.initUsersDetail($stateParams.userNumber);
	$scope.getUser = UsersDetailService.getUser;
	$scope.getError = UsersDetailService.getError;
	$scope.goToUsersListPage = UsersDetailService.goToUsersListPage;

	$scope.submitForm = function(isValid) {

	    // check to make sure the form is completely valid
	    if (isValid) {
	    	alert('Our form is valid. You can submit the form now.');
	    	UsersDetailService.updateUsersDetail();
	    }
	}

});



module.controller("UsersUpdateController", function($scope, UsersUpdateService) {
	

});
