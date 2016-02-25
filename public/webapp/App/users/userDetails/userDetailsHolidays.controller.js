angular.module("employeesMngApp").controller("UserDetailsHolidaysController", function($scope, $stateParams, UserDetailsHolidaysService) {

	UserDetailsHolidaysService.initUsersHolidaysDetail($stateParams.userId);

	$scope.getUserHolidaysList = UserDetailsHolidaysService.getUserHolidaysList;

	$scope.getError = UserDetailsHolidaysService.getError;
	$scope.getStatusMessage = UserDetailsHolidaysService.getStatusMessage;
	$scope.getMessageStyleClass = UserDetailsHolidaysService.getMessageStyleClass;
	$scope.goToUsersListPage = UserDetailsHolidaysService.goToUsersListPage;

	$scope.changePopup = UserDetailsHolidaysService.changePopup;
	$scope.changeDaysTaken = UserDetailsHolidaysService.changeDaysTaken; 
	$scope.disabled = UserDetailsHolidaysService.disabled;
	$scope.open2 = UserDetailsHolidaysService.open2;
	$scope.open1 = UserDetailsHolidaysService.open1;
	$scope.getHolidays = UserDetailsHolidaysService.getHolidays;
	$scope.getUserHolidays = UserDetailsHolidaysService.getUserHolidays;

	$scope.submitForm = UserDetailsHolidaysService.updateUsersDetailHolidays;

});
