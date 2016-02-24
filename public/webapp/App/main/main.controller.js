var module = angular.module("employeesMngApp");

module.controller("MainController", function($scope, $state, PageDataService) {
	
	$scope.getPageDesc = PageDataService.getPageDesc;
	
	$scope.stateIsNastedFrom = function(parrentState) {
	
		return $state.includes(parrentState);

	}
	
});
