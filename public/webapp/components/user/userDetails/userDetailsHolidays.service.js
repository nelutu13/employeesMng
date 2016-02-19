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
		
		console.log(_userHolidays);
		
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

	
	var holidays = {	
		
		popup1: {
			opened: false,
			dateOptions: {
				startingDay: 0,
				minDate: new Date(),
				maxDate: new Date(2017, 11, 30)
			}
		},
	
		popup2: {
		opened: false,
		dateOptions: {
				startingDay: 0,
				minDate: new Date(),
				maxDate: new Date(2017, 11, 30)
			}
		}
	};
	
	service.getHolidays = function() {
		return holidays;
	};
	
	service.open1 = function() {
		holidays.popup1.opened = true;
	};
	
	service.open2 = function() {
		holidays.popup2.opened = true;
	};
	
	service.disabled = function(date, mode) {
	    return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
	};
	
	service.changeDaysTaken = function() {

		if(_userHolidays.daysTaken == undefined) _userHolidays.daysTaken = null;
		if(_userHolidays.fromDate == undefined) _userHolidays.fromDate = null;
		if(_userHolidays.toDate == undefined) _userHolidays.toDate = null;

		if(_userHolidays.daysTaken !== null) {
			if(_userHolidays.fromDate !== null) {
				var currTimeInMillSec 	= _userHolidays.fromDate.getTime();
				var tempTimeDiffInDays 	= 0;
				var tempTimeInMillSec 	= 0;
				var countTotalDays 	= _userHolidays.daysTaken;
				for(i=0; i<countTotalDays; i++) {
					var daysCountedInMillSec 	= i * (1000 * 3600 * 24);
					var tempTimeInMillSec 		= currTimeInMillSec + daysCountedInMillSec;
					_userHolidays.toDate = new Date(tempTimeInMillSec);
					if(   (_userHolidays.toDate.getDay()===0) || (_userHolidays.toDate.getDay()===6)   ) {
						countTotalDays++;
					}
				}
			} else {
				_userHolidays.toDate = null;
			}
		} else if(_userHolidays.fromDate !== null) {
			_userHolidays.toDate = null;
		}
		console.log(_userHolidays.toDate);
	}
	
	service.changePopup = function() {

		if(_userHolidays.daysTaken == undefined) _userHolidays.daysTaken = null;
		if(_userHolidays.fromDate == undefined) _userHolidays.fromDate = null;
		if(_userHolidays.toDate == undefined) _userHolidays.toDate = null;
		if((_userHolidays.fromDate === null) && (_userHolidays.toDate === null)) {
			_userHolidays.daysTaken = 0;
		} else if(   (_userHolidays.fromDate !== null) && (_userHolidays.toDate === null) && (_userHolidays.daysTaken !== null)   ) {
			
			var currTimeInMillSec 	= _userHolidays.fromDate.getTime();
			var tempTimeDiffInDays 	= 0;
			var tempTimeInMillSec 	= 0;
			var countTotalDays 	= _userHolidays.daysTaken;
			for(i=0; i<countTotalDays; i++) {
				var daysCountedInMillSec 	= i * (1000 * 3600 * 24);
				var tempTimeInMillSec 		= currTimeInMillSec + daysCountedInMillSec;
				_userHolidays.toDate = new Date(tempTimeInMillSec);
				if(   (_userHolidays.toDate.getDay()=== 0) || (_userHolidays.toDate.getDay()=== 6)   ) {
					countTotalDays++;
				}
			}
		} else if(   (_userHolidays.fromDate !== null)  && (_userHolidays.toDate !== null)   ) {
			_userHolidays.daysTaken = service.dayDiff(_userHolidays.fromDate, _userHolidays.toDate);
		}
		console.log(_userHolidays.toDate);
	}
	
	service.dayDiff = function(firstDate,secondDate){

		var timeDiff = secondDate.getTime() - firstDate.getTime();				
		var timeDiffInDays = Math.floor(timeDiff / (1000 * 3600 * 24)) + 1;
		
		var i = 0;
		var timeInMillSec = 0;

		var currTimeDiff = _userHolidays.fromDate.getTime();
		var initTimeDiffInDays = Math.floor(currTimeDiff / (1000 * 3600 * 24));
		var tempTimeDiffInDays = 0;
		var timeInMillSec = 0;
		
		var totalDays = 0;
		for(i=0; i<timeDiffInDays; i++) {
			
			tempTimeDiffInDays = initTimeDiffInDays + i;
			timeInMillSec = tempTimeDiffInDays * (1000 * 3600 * 24);
			var thatDate = new Date(timeInMillSec);
			if(   (thatDate.getDay()!==0) && (thatDate.getDay()!==6)   ) {
				totalDays++;
			}
		}
		
		return totalDays;
		
	 }

	
	
	return service;
	
});
