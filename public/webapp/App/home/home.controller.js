	var app = angular.module("employeesMngApp");

	var HomeController = function($scope) {

		$scope.birthdays = ['click', 'the', 'buttons'];

	};

	app.controller("HomeController", HomeController);
