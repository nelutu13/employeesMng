var module = angular.module("employeesMngApp");

module.controller("UserDetailsController", function($scope, $stateParams,
		UserDetailsService) {

	UserDetailsService.initUsersDetail($stateParams.userId);
	$scope.getUser = UserDetailsService.getUser;
	$scope.getError = UserDetailsService.getError;
	$scope.getStatusMessage = UserDetailsService.getStatusMessage;
	$scope.getMessageStyleClass = UserDetailsService.getMessageStyleClass;

	$scope.goToUsersListPage = UserDetailsService.goToUsersListPage;

	$scope.submitForm = function(isValid) {

		if (isValid) {
			UserDetailsService.updateUsersDetail();
		} else {
			alert('The user form is not yet valid.');
		}

	}

});
