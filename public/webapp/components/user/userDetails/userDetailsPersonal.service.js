angular.module("employeesMngApp").factory("UserDetailsPersonalService", function($http, $state, $timeout) {

	var service = this, _user = {}, _error = false, _statusMessage = false, _messageStyleClass = "";

	service.initUsersDetail = function(userId) {
		
		_user = {}; _error = false; _statusMessage = false;	_messageStyleClass = "";
		
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
       	_statusMessage = "Updating ...";
       	
       	$timeout(function() {
			return $http.put("http://localhost:8080/users?userId=" + _user.id, _user).then(
				function(response) {
			       	_messageStyleClass = "alert-success";
					_statusMessage = "User saved succesfully";
				}, function(error) {
					_statusMessage = false;
					_error = 'Could not get the user details data from server.';
					$state.go('error_page', {'errorDesc':_error, 'escapePageState':'users.list', 'buttonText':'Back to users list'});
				});
		}, 2000);
       	
	};

	service.getUser = function() {
		return _user;
	}

	service.getError = function() {
		return _error;
	}

	service.getStatusMessage = function() {
		return _statusMessage;
	}

	service.getMessageStyleClass = function() {
		return _messageStyleClass;
	}

	service.goToUsersListPage = function() {
		$state.go('users.list');
	}

	return service;

});
