angular.module("employeesMngApp").controller("UserDetailsController", function($scope, $stateParams, UserDetailsService) {

	$scope.getTabDesc = UserDetailsService.getTabDesc;

});
