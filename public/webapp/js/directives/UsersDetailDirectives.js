var INTEGER_REGEXP = /^\d+$/;

var module = angular.module("employeesMngApp");

module.directive('integer', function() {
	return {
		require : 'ngModel',
		link : function(scope, elm, attrs, ctrl) {
			ctrl.$validators.integer = function(modelValue, viewValue) {
				if (ctrl.$isEmpty(modelValue)) {
					// consider empty models to be valid
					return true;
				}

				if (INTEGER_REGEXP.test(viewValue)) {
					// it is valid
					return true;
				}

				// it is invalid
				return false;
			};
		}
	};
});

app.directive('checkEmailAlreadyTaken', function($q, $timeout) {
	  return {
	    require: 'ngModel',
	    link: function(scope, elm, attrs, ctrl) {
	      var usernames = ['a@b.c', 'example@email.com'];

	      ctrl.$asyncValidators.checkEmailAlreadyTaken = function(modelValue, viewValue) {

	        if (ctrl.$isEmpty(modelValue)) {
	          // consider empty model valid
	          return $q.when();
	        }

	        var def = $q.defer();

	        $timeout(function() {
	          // Mock a delayed response
	          if (usernames.indexOf(modelValue) === -1) {
	            // The username is available
	            def.resolve();
	          } else {
	            def.reject();
	          }

	        }, 2000);

	        return def.promise;
	      };
	    }
	  };
	});

app.directive('compareTo', function() {
	return {
      require: "ngModel",
      scope: {
        otherModelValue: "=compareTo"
      },
      link: function(scope, element, attributes, ngModel) {

        ngModel.$validators.compareTo = function(modelValue) {
          return modelValue == scope.otherModelValue;
        };

        scope.$watch("otherModelValue", function() {
          ngModel.$validate();
        });
      }
    };
});
