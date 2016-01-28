(function() {

	var app = angular.module("employeesMngApp");

	var HomeController = function($scope, PageDataService) {

	    PageDataService.setPageDescription("Home page");
	    PageDataService.setPage("home");

	};

	app.controller("HomeController", HomeController);

}());