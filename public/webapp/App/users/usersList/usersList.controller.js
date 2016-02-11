var module = angular.module("employeesMngApp");

module.controller("UsersListController", function($scope, UsersListService,
		$uibModal) {

	UsersListService.initUsers();

	$scope.getUsers = UsersListService.getUsers;
	$scope.getError = UsersListService.getError;
	$scope.goToUsersDetail = UsersListService.goToUsersDetail;
	$scope.getStatusMessage = UsersListService.getStatusMessage;
	$scope.getMessageStyleClass = UsersListService.getMessageStyleClass;
	$scope.getKeysOfCollection = UsersListService.getKeysOfCollection;
	$scope.deleteUser = UsersListService.deleteUser;
	$scope.goToUserCreate = UsersListService.goToUserCreate;

	$scope.getPagination = UsersListService.getPagination;
	$scope.getPages = UsersListService.getPages;
	$scope.setCurrentPage = UsersListService.setCurrentPage;
	$scope.setPrevPage = UsersListService.setPrevPage;
	$scope.setNextPage = UsersListService.setNextPage;


	$scope.predicate = 'name';
	$scope.reverse = false;
	$scope.getOrder = function() {
	}
	$scope.updatePredicate = function(key) {
		$scope.predicate = key;
		$scope.reverse = !$scope.reverse;
	}
	$scope.sortOrder = "-name";

});
