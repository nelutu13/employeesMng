var module = angular.module("employeesMngApp");

module.factory("PageDataService", function($state, PAGE_DESC) {
	
	var service = this;
	
	service.getPageDesc = function() {
		if (PAGE_DESC[$state.current.name] != undefined)
		{
			return PAGE_DESC[$state.current.name];
		} else {
			return 'The state "' + $state.current.name + '" is not defined.';
		}
	}
	
	return service;
	
});
