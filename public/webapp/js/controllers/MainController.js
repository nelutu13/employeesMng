var module = angular.module("employeesMngApp");

module.controller("MainController", function($scope, PageDataService) {
	
	$scope.getPageDesc = PageDataService.getPageDesc;
	
});
