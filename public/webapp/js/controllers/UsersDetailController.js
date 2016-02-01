var module = angular.module("employeesMngApp");

module.controller("UsersDetailController", function($scope, $stateParams, UsersDetailService) {
	
	UsersDetailService.initUsersDetail($stateParams.number);
	$scope.getUser = UsersDetailService.getUser;
	$scope.getError = UsersDetailService.getError;

});
