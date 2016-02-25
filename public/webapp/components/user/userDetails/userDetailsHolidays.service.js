angular.module("employeesMngApp").factory("UserDetailsHolidaysService", function($http, $state, $timeout) {

	var service = this, _userHolidays = {}, _userHolidaysList = [], _error = false, _statusMessage = false, _messageStyleClass = "";

	service.initUsersHolidaysDetail = function(userId) {
		
		_userHolidays = {}; _userHolidaysList = []; _error = false; _statusMessage = false;	_messageStyleClass = "";
		 
		
		return $http.get("http://localhost:8080/userHolidays?userId=" + userId).then(
			function(response) {

				_userHolidays.userId = userId;
				_userHolidaysList = response.data;

			}, function(error) {
				
				_error = 'Could not get the user details data from server.';
				$state.go('error_page', {'errorDesc':_error, 'escapePageState':'users.list', 'buttonText':'Back to users list'});
				
			});
	};

	service.getUserHolidaysList = function() {
		return _userHolidaysList;
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

	service.updateUsersDetailHolidays = function() {

		_userHolidays.fromDate = _userHolidays.fromDate.getFullYear() + "-" + (_userHolidays.fromDate.getMonth() + 1) + "-" + _userHolidays.fromDate.getDate();		
		_userHolidays.toDate = _userHolidays.toDate.getFullYear() + "-" + (_userHolidays.toDate.getMonth() + 1) + "-" + _userHolidays.toDate.getDate();
		
		_error = false;
       	_messageStyleClass = "alert-warning";
       	_statusMessage = "Saving ...";

       	$timeout(function() {
			return $http.post("http://localhost:8080/userHolidays", _userHolidays).then(
				function(response) {
			       	_messageStyleClass = "alert-success";
					_statusMessage = "User holidays saved succesfully";
					_userHolidaysList.push(_userHolidays);
					_userHolidays = {userId: _userHolidays.userId, fromDate: null, daysTaken: null, toDate: null, notes: null};
				}, function(error) {
					_statusMessage = false;
					_error = 'Could not get the user holidays details data from server.';
					$state.go('error_page', {'errorDesc':_error, 'escapePageState':'users.list', 'buttonText':'Back to users list'});
				});
       	}, 2000);
       	
	};

	service.getUserHolidays = function() {
		return _userHolidays;
	}



	return service;

});
