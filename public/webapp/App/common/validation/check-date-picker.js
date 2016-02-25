angular.module("employeesMngApp").directive('checkDatePicker', function() {

	return {
		
		require : "ngModel",

		link : function(scope, element, attributes, ngModel) {

			ngModel.$validators.checkDatePicker = function(toDate) {

				if( toDate - scope.getUserHolidays().fromDate >= 0) {
					return true;
				}
				
				return false;
				
			};

			scope.$watch("getUserHolidays().fromDate", function() {
				ngModel.$validate();
			});
			
		}

	};

});
