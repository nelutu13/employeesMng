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
