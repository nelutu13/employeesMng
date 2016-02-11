angular.module("employeesMngApp").controller("UserDetailsController", function($scope, $stateParams, UserDetailsService) {

	UserDetailsService.initUsersDetail($stateParams.userId);
	$scope.getUser = UserDetailsService.getUser;
	$scope.getError = UserDetailsService.getError;
	$scope.getStatusMessage = UserDetailsService.getStatusMessage;
	$scope.getMessageStyleClass = UserDetailsService.getMessageStyleClass;
	$scope.goToUsersListPage = UserDetailsService.goToUsersListPage;

	$scope.submitForm = function() {

		UserDetailsService.updateUsersDetail();
		
	}

});
