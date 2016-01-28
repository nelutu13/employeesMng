(function() {

	var app = angular.module("employeesMngApp");

	var MainController = function($scope, $state, PageDataService, appConfig) {

		$scope.state = $state;
		
		$scope.getPageName = function(name) {
			return appConfig[name];
		};
		
	};

	app.controller("MainController", MainController);

}());