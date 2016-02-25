angular.module("employeesMngApp").controller("UserDetailsPersonalController", function($scope, $stateParams, UserDetailsPersonalService) {

	UserDetailsPersonalService.initUsersDetail($stateParams.userId);
	$scope.getUser = UserDetailsPersonalService.getUser;
	$scope.getError = UserDetailsPersonalService.getError;
	$scope.getStatusMessage = UserDetailsPersonalService.getStatusMessage;
	$scope.getMessageStyleClass = UserDetailsPersonalService.getMessageStyleClass;
	$scope.goToUsersListPage = UserDetailsPersonalService.goToUsersListPage;

	$scope.submitForm = UserDetailsPersonalService.updateUsersDetail;

});
