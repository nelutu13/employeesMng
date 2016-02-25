angular.module("employeesMngApp").controller("DatePickerController", function($scope, UserDetailsHolidaysService) {
	
	$scope.opened = {};

	$scope.dateOptions = {
			startingDay: 0,
			minDate: new Date(),
			maxDate: new Date(2017, 11, 30)
	}

	$scope.open = function(elementName) {

		$scope.opened[elementName] = true;
		
	};

	$scope.disabled = function(date, mode) {
	    return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
	};

	$scope.changeDaysTaken = function() {

		if(UserDetailsHolidaysService.getUserHolidays().daysTaken == undefined) UserDetailsHolidaysService.getUserHolidays().daysTaken = null;
		if(UserDetailsHolidaysService.getUserHolidays().fromDate == undefined) UserDetailsHolidaysService.getUserHolidays().fromDate = null;
		if(UserDetailsHolidaysService.getUserHolidays().toDate == undefined) UserDetailsHolidaysService.getUserHolidays().toDate = null;

		if(UserDetailsHolidaysService.getUserHolidays().daysTaken !== null) {
			if(UserDetailsHolidaysService.getUserHolidays().fromDate !== null) {
				var currTimeInMillSec = UserDetailsHolidaysService.getUserHolidays().fromDate.getTime();
				var tempTimeDiffInDays = 0;
				var tempTimeInMillSec = 0;
				var countTotalDays 	= UserDetailsHolidaysService.getUserHolidays().daysTaken;
				for(i=0; i<countTotalDays; i++) {
					var daysCountedInMillSec 	= i * (1000 * 3600 * 24);
					var tempTimeInMillSec 		= currTimeInMillSec + daysCountedInMillSec;
					UserDetailsHolidaysService.getUserHolidays().toDate = new Date(tempTimeInMillSec);
					if(   (UserDetailsHolidaysService.getUserHolidays().toDate.getDay()===0) || (UserDetailsHolidaysService.getUserHolidays().toDate.getDay()===6)   ) {
						countTotalDays++;
					}
				}
			} else {
				UserDetailsHolidaysService.getUserHolidays().toDate = null;
			}
		} else if(UserDetailsHolidaysService.getUserHolidays().fromDate !== null) {
			UserDetailsHolidaysService.getUserHolidays().toDate = null;
		}
	}

	$scope.changePopup = function() {

		if(typeof UserDetailsHolidaysService.getUserHolidays().daysTaken == undefined) ;//UserDetailsHolidaysService.getUserHolidays().daysTaken = null;
		if(UserDetailsHolidaysService.getUserHolidays().fromDate == undefined) UserDetailsHolidaysService.getUserHolidays().fromDate = null;
		if(UserDetailsHolidaysService.getUserHolidays().toDate == undefined) UserDetailsHolidaysService.getUserHolidays().toDate = null;
		if((UserDetailsHolidaysService.getUserHolidays().fromDate === null) && (UserDetailsHolidaysService.getUserHolidays().toDate === null)) {
			UserDetailsHolidaysService.getUserHolidays().daysTaken = 0;
		} else if(   (UserDetailsHolidaysService.getUserHolidays().fromDate !== null) && (UserDetailsHolidaysService.getUserHolidays().toDate === null) && (UserDetailsHolidaysService.getUserHolidays().daysTaken !== null)   ) {
			
			var currTimeInMillSec 	= UserDetailsHolidaysService.getUserHolidays().fromDate.getTime();
			var tempTimeDiffInDays 	= 0;
			var tempTimeInMillSec 	= 0;
			var countTotalDays 	= UserDetailsHolidaysService.getUserHolidays().daysTaken;
			for(i=0; i<countTotalDays; i++) {
				var daysCountedInMillSec 	= i * (1000 * 3600 * 24);
				var tempTimeInMillSec 		= currTimeInMillSec + daysCountedInMillSec;
				UserDetailsHolidaysService.getUserHolidays().toDate = new Date(tempTimeInMillSec);
				if(   (UserDetailsHolidaysService.getUserHolidays().toDate.getDay()=== 0) || (UserDetailsHolidaysService.getUserHolidays().toDate.getDay()=== 6)   ) {
					countTotalDays++;
				}
			}
		} else if(   (UserDetailsHolidaysService.getUserHolidays().fromDate !== null)  && (UserDetailsHolidaysService.getUserHolidays().toDate !== null)   ) {
			UserDetailsHolidaysService.getUserHolidays().daysTaken = dayDiff(UserDetailsHolidaysService.getUserHolidays().fromDate, UserDetailsHolidaysService.getUserHolidays().toDate);
		}
	};

	var dayDiff = function(firstDate,secondDate){

		var timeDiff = secondDate.getTime() - firstDate.getTime();				
		var timeDiffInDays = Math.floor(timeDiff / (1000 * 3600 * 24)) + 1;

		var i = 0;
		var timeInMillSec = 0;

		var currTimeDiff = UserDetailsHolidaysService.getUserHolidays().fromDate.getTime();
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

	 };



});
