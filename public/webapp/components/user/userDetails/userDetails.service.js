angular.module("employeesMngApp").factory("UserDetailsService", function($state, TAB_DESC) {

	var service = this;
	
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
