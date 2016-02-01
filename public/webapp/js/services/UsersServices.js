var module = angular.module("employeesMngApp");

module.factory("UsersService", function($http) {

	var service = this, _users = [], _error = false;
	
	service.initUsers = function() {
		return $http.get("http://localhost:8080/users").then(
			function(response) {
				_users = response.data;
			}, function(error) {
				_error = 'Could not get the users list from server.';
			});
	};

	service.getUsers = function() {
		return _users;
	}
	
	service.getError = function() {
		return _error;
	}
	
	service.getKeysOfCollection = function(obj) {
	    if (!obj) {
	      return [];
	    }
	    return Object.keys(obj);
	}
	
	return service;

});



module.factory("UsersDetailService", function($http) {

	var service = this, _user = {}, _error = false;

	service.initUsersDetail = function(number) {
		return $http.get("http://localhost:8080/usersDetail?number=" + number).then(
			function(response) {
				_user = response.data;
			}, function(error) {
				_error = 'Could not get the user details data from server.';
			});
	};

	service.getUser = function() {
		return _user;
	}

	service.getError = function() {
		return _error;
	}

	return service;

});
