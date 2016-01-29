var module = angular.module("employeesMngApp");

module.controller("UsersDetailController", function($scope, $state, $stateParams, UsersDetailService) {
	
    var onUserComplete = function(data) {
        $scope.user = data;
    };

	var onError = function(response) {
	    $scope.error = "Could not get the user list";
	};
	
    UsersDetailService.getUsersDetail($stateParams.number).then(onUserComplete, onError);

    //$scope.userNumber = $stateParams.number;

});
