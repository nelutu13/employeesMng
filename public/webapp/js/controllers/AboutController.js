(function() {

	var app = angular.module("employeesMngApp");

	var AboutController = function($scope, PageDataService) {

	    PageDataService.setPageDescription("About");
	    PageDataService.setPage("about");

	};

	app.controller("AboutController", AboutController);

}());