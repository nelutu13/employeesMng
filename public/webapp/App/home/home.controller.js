	var app = angular.module("employeesMngApp");

	var HomeController = function($scope) {

		$scope.birthdays = ['1991', '1992', '1993'];

	};

	app.controller("HomeController", HomeController);
