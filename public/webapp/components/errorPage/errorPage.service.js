var module = angular.module("employeesMngApp");

module.factory("ErrorPageService", function($http, $state, $stateParams) {

	var service = this;
	
	service.getError = function() {
		return $stateParams.errorDesc;
	}

	service.goToEscapePage = function() {
		$state.go($stateParams.escapePageState);
	};
	
	service.getButtonText = function() {
		return $stateParams.buttonText;
	};

	return service;

});
