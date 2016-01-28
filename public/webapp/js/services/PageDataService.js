(function() {

	var PageDataService = function($http) {

		var pageDescription = 'Not planed';
		var page = 'home';

		var getPageDescription = function() {
			return pageDescription;
		};

		var getPage = function() {
			return page;
		};

		var setPageDescription = function(newPageDescription) {
			pageDescription = newPageDescription;
		};

		var setPage = function(newPage) {
			page = newPage;
		};

		return {
			getPageDescription : getPageDescription,
			setPageDescription : setPageDescription,
			getPage : getPage,
			setPage : setPage
		};

	};

	var module = angular.module("employeesMngApp");
	module.factory("PageDataService", PageDataService);

}());