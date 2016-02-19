var module = angular.module("employeesMngApp");

module.controller("AboutController", function($scope) {
    
    $scope.authors = [
        {
            name: 'Author 1',
            LOCs: 1 
        },
        {
            name: 'Author 2',
            LOCs: 1
        },
        {
            name: 'Superviser 1',
            LOCs: 1
        }
    ];

});
