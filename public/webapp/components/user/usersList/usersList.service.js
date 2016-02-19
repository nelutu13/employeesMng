var module = angular.module("employeesMngApp");

module.factory("UsersListService", function($http, $state, $stateParams, $timeout, $uibModal) {

	var service = this, _users = [], _error = false, _statusMessage = false, _messageStyleClass = "", pages = [], totalNumberOfUsers = -1;
	var pagination = {'current':1, 'first':1, 'last':1};
	service.initUsers = function() {
		
		_users = []; _error = false; _statusMessage = false; _messageStyleClass = ""; pages = []; totalNumberOfUsers = -1;
		pagination = {'current':1, 'first':1, 'last':1};
		
		$http.get("http://localhost:8080/usersPaginationCount").then(
				function(response) {
					
					totalNumberOfUsers = response.data;

					pageSize = 3;//to do: move it to constants
					numberOfPages = Math.ceil(totalNumberOfUsers / pageSize);
					for(i = 1; i<=numberOfPages; i++) pages.push(i);
					
					if($stateParams.pageNumber == undefined) {$stateParams.pageNumber = 1;} if($stateParams.pageNumber < 1) {$stateParams.pageNumber = 1;}
					firstrow = ($stateParams.pageNumber-1)*pageSize + 1;
					
					pagination = {'current':$stateParams.pageNumber, 'first':1, 'last':numberOfPages}
					
					$http.get("http://localhost:8080/usersPagination?firstrow=" + firstrow + "&pageSize=" + pageSize).then(
						function(response) {
							_users = response.data;
						}, function(error) {
							_error = 'Could not get the user list from server.';
						});
				}, function(error) {
					_error = 'Could not get the user list from server.';
				});

	};

	service.getPagination = function() {
		return pagination;
	}
	
	service.getPages = function() {
		return pages;
	}
	
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
		$state.go('users.details.personal', {'userId':userId});
	};

	service.setCurrentPage = function(pageNumber) {
		$state.go('users.list', {'pageNumber':pageNumber});
	};
	
	service.setPrevPage = function(pageNumber) {
		if(parseInt(pageNumber) > pagination.first) {
			$state.go('users.list', {'pageNumber':(parseInt(pageNumber)-1)});
		}
	}
	
	service.setNextPage = function(pageNumber) {
		if(parseInt(pageNumber) < pagination.last) {
			$state.go('users.list', {'pageNumber':(parseInt(pageNumber)+1)});
		}
	}
	
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
		
	service.deleteUser = function(userId) {
	
		var modalInstance = $uibModal.open({
			templateUrl : 'App/common/modal-delete.html',
			controller : function($scope, $uibModalInstance) {
				$scope.modalOptions = {
					closeButtonText : 'Cancel',
					actionButtonText : 'Delete',
					headerText : 'Delete ' + userId + '?',
					bodyText : 'Are you sure you want to delete this user?'
				};
				$scope.ok = function() {$uibModalInstance.close();};
				$scope.cancel = function() {$uibModalInstance.dismiss('cancel');};
			}

		});

		modalInstance.result.then(function() {
			service.deleteUserRequest(userId);
		});
	
	};
	
	service.goToUserCreate = function(userId) {
		$state.go('users.details.create');
	};

	return service;

});
