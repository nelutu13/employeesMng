var module = angular.module("employeesMngApp");

module.factory("UsersListService", function($http, $state, $timeout, ModalDeleteService) {

	var service = this, _users = [], _error = false, _statusMessage = false, _messageStyleClass = "";
	
	service.initUsers = function() {
		
		_users = []; _error = false; _statusMessage = false; _messageStyleClass = "";
		
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

	service.getStatusMessage = function() {
		return _statusMessage;
	}

	service.getMessageStyleClass = function() {
		return _messageStyleClass;
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

	service.deleteUser = function(userId) {

		var modalOptions = {
            closeButtonText: 'Cancel',
            actionButtonText: 'Delete',
            headerText: 'Delete ' + userId + '?',
            bodyText: 'Are you sure you want to delete this user?'
        };

        ModalDeleteService.showModal({}, modalOptions).then(
			function (result) {
				service.deleteUserRequest(userId);
			}
		);
		
	};

	service.deleteUserRequest = function(userId) {
		
		_error = false;
       	_messageStyleClass = "alert-warning";
       	_statusMessage = "Deleting user. pending...";
		
       	$timeout(function() {
			$http.delete("http://localhost:8080/users?userId=" + userId).then(
				function(response) {
					for( i=_users.length-1; i>=0; i--) {
					    if( _users[i].id == userId) _users.splice(i,1);
					}
			       	_messageStyleClass = "alert-success";
					_statusMessage = "The user was succesfully deleted";
					
				}, function(error) {
					_statusMessage = false;
					_error = 'Could not delete the user.';
					$state.go('error_page', {'errorDesc':_error, 'escapePageState':'users.list', 'buttonText':'Back to users list'});
				});
		}, 2000);

	};

	
	
	return service;

});
