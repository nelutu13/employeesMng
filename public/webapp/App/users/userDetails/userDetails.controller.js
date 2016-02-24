angular.module("employeesMngApp").controller("UserDetailsController", function($scope, $stateParams, PageDataService) {

	$scope.getTabDesc = PageDataService.getTabDesc;
	
	$scope.stateParams_userId = $stateParams.userId;

});
