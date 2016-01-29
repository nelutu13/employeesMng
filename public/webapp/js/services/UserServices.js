var module = angular.module("employeesMngApp");
  module.factory("$getUsersServ", function($http) {

		 var service = this;
		 service.getUsers = function() {
	      return $http.get("http://localhost:8080/users")
	                  .then(function(response){
	                    return response.data;
	                  });
		 };
		 return service;
	    
  });
  
