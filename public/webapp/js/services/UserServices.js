(function(){
  
  var getUsersServ = function($http) {
    
    var getUsers = function() {
      return $http.get("http://localhost:8080/users")
                  .then(function(response){
                    return response.data;
                  });
    };
    
    return {
      getUsers: getUsers,
    };
    
  };
  
  var module = angular.module("employeesMngApp");
  module.factory("$getUsersServ", getUsersServ);
  
}());