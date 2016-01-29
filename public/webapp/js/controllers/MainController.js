
	var app = angular.module("employeesMngApp");

	var MainController = function($scope, $state, PageDataService, appConfig) {

		
		$scope.getPageName = function() {
			return appConfig[$state.current.name];
		};
		

	};

	app.controller("MainController", MainController);

