var module = angular.module("employeesMngApp");

module.controller("ErrorPageController", function($scope, ErrorPageService) {
	
	$scope.getError = ErrorPageService.getError;

	$scope.goToEscapePage = ErrorPageService.goToEscapePage;
	
	$scope.getButtonText = ErrorPageService.getButtonText;
	
});
