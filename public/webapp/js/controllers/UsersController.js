var module = angular.module("employeesMngApp");

module.controller("UsersController", function($scope, UsersService) {

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



module.controller("UserDetailController", function($scope, $stateParams, UsersDetailService) {
	
	UsersDetailService.initUsersDetail($stateParams.userId);
	$scope.getUser = UsersDetailService.getUser;
	$scope.getError = UsersDetailService.getError;
	$scope.getStatusMessage = UsersDetailService.getStatusMessage;
	$scope.getMessageStyleClass = UsersDetailService.getMessageStyleClass;
	
	$scope.goToUsersListPage = UsersDetailService.goToUsersListPage;

	$scope.submitForm = function(isValid) {

	    // check to make sure the form is completely valid
	    if (isValid) {
	    	UsersDetailService.updateUsersDetail();
	    } else {
	    	alert('The user form is not yet valid.');
	    }
	    
	}

});
