var module = angular.module("employeesMngApp");

module.factory("UsersService", function($http, $state) {

	var service = this, _users = [], _error = false;
	
	service.initUsers = function() {
		$http.get("http://localhost:8080/users").then(
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

	service.goToUsersDetail = function(userNumber) {
		$state.go('users.detail', {'userNumber':userNumber});
	};

	return service;

});



module.factory("UsersDetailService", function($http, $state) {

	var service = this, _user = {}, _error = false;

	service.initUsersDetail = function(userNumber) {
		
		_user = {};
		_error = false;
		
		return $http.get("http://localhost:8080/usersDetail?userNumber=" + userNumber).then(
			function(response) {
				_user = response.data;
				_user['confirmPassword'] = _user['password'];
			
			}, function(error) {
				_error = 'Could not get the user details data from server.';
				$state.go('error_page', {'errorDesc':_error, 'escapePageState':'users.list', 'buttonText':'Back to users list'});
			});
	};

	service.getUser = function() {
		return _user;
	}

	service.getError = function() {
		return _error;
	}

	service.goToUsersListPage = function() {
		$state.go('users.list');
	}

	
	
	return service;

});
