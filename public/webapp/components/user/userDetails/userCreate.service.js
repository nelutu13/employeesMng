angular.module("employeesMngApp").factory("UserCreateService", function($http, $state, $timeout) {

	var service = this, _user = {}, _error = false, _statusMessage = false, _messageStyleClass = "";
	
	service.initUserCreate = function(userId) {
		
		_user = {}; _error = false; _statusMessage = false;	_messageStyleClass = "";
		
	}
	
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

	service.createUser = function() {
		
		_error = false;
       	_messageStyleClass = "alert-warning";
       	_statusMessage = "Creating user. pending...";

       	$timeout(function() {
			return $http.post("http://localhost:8080/users", _user).then(
				function(response) {
					debugger;
					_user.id = response.data;
			       	_messageStyleClass = "alert-success";
					_statusMessage = "User saved succesfully";
				}, function(error) {
					_statusMessage = false;
					_error = 'Could not get the user details data from server.';
					$state.go('error_page', {'errorDesc':_error, 'escapePageState':'users.list', 'buttonText':'Back to users list'});
				});
       	}, 2000);

	};

	
	
	return service;

});
