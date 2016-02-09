angular.module("employeesMngApp").controller("UserCreateController", function($scope, UserCreateService) {
	
	UserCreateService.initUserCreate();

	$scope.getUser = UserCreateService.getUser;
	$scope.getError = UserCreateService.getError;
	$scope.getStatusMessage = UserCreateService.getStatusMessage;
	$scope.getMessageStyleClass = UserCreateService.getMessageStyleClass;
	$scope.goToUsersListPage = UserCreateService.goToUsersListPage;

	$scope.submitForm = function(isValid) {

		if (isValid) {
			UserCreateService.createUser();
		} else {
			alert('The user form is not yet valid.');
		}

	}

});
