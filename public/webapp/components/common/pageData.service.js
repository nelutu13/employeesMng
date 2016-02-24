angular.module("employeesMngApp").factory("PageDataService", function($state, PAGE_DESC, TAB_DESC) {
	
	var service = this;
	
	service.getPageDesc = function() {
		if (PAGE_DESC[$state.current.name] != undefined)
		{
			return PAGE_DESC[$state.current.name];
		} else {
			return 'The state "' + $state.current.name + '" is not defined.';
		}
	}
	
	service.getTabDesc = function() {
		if (TAB_DESC[$state.current.name] != undefined)
		{
			return TAB_DESC[$state.current.name];
		} else {
			return 'The state "' + $state.current.name + '" is not defined.';
		}
	}

	
	
	return service;
	
});
