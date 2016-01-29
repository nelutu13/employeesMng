var module = angular.module("employeesMngApp");

module.factory("$getUsersServ", function($http) {

	var service = this;
	
	service.getUsers = function() {
		return $http.get("http://localhost:8080/users").then(
			function(response) {
				return response.data;
			});
	};

	return service;

});

module.factory("UsersDetailService", function($http) {

	var service = this;
	
	service.getUsersDetail = function(number) {
		return $http.get("http://localhost:8080/usersDetail?number=" + number).then(
			function(response) {
				return response.data;
			});
	};

	return service;

});

