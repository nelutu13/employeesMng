var module = angular.module("employeesMngApp");

module.controller("UsersDetailController", function($scope, $stateParams, UsersDetailService) {
	
	UsersDetailService.initUsersDetail($stateParams.userNumber);
	$scope.getUser = UsersDetailService.getUser;
	$scope.getError = UsersDetailService.getError;
	$scope.goToUsersListPage = UsersDetailService.goToUsersListPage;

	$scope.submitForm = function(isValid) {

	    // check to make sure the form is completely valid
	    if (isValid) {
	      alert('Our form is valid. You can submit the form now.');
	    }
	}

});
