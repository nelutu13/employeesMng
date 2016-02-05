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

	service.goToUsersDetail = function(userId) {
		$state.go('users.detail', {'userId':userId});
	};

	return service;

});



module.factory("UsersDetailService", function($http, $state, $timeout) {

	var service = this, _user = {}, _error = false, _statusMessage = false, _messageStyleClass = "";

	service.initUsersDetail = function(userId) {
		
		_user = {};
		_error = false;
		_statusMessage = false;
		
		return $http.get("http://localhost:8080/userDetail?userId=" + userId).then(
			function(response) {
				_user = response.data;
				_user['confirmPassword'] = _user['password'];
			
			}, function(error) {
				_error = 'Could not get the user details data from server.';
				$state.go('error_page', {'errorDesc':_error, 'escapePageState':'users.list', 'buttonText':'Back to users list'});
			});
	};

	service.updateUsersDetail = function() {	
		
		_error = false;
       	_messageStyleClass = "alert-warning";
       	_statusMessage = "Updating user. pending...";

       	$timeout(function() {
			return $http.post("http://localhost:8080/users", _user).then(
				function(response) {
					_user = response.data;
			       	_messageStyleClass = "alert-success";
					_statusMessage = "User saved succesfully";
				}, function(error) {
					_error = 'Could not get the user details data from server.';
					$state.go('error_page', {'errorDesc':_error, 'escapePageState':'users.list', 'buttonText':'Back to users list'});
				});
		}, 2000);

	};

	service.getUser = function() {
		return _user;
	}

	service.getStatusMessage = function() {
		return _statusMessage;
	}

	service.getError = function() {
		return _error;
	}

	service.getMessageStyleClass = function() {
		return _messageStyleClass;
	}

	service.goToUsersListPage = function() {
		$state.go('users.list');
	}

	return service;

});
