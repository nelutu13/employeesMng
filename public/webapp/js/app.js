'use strict'

var employeesMngApp = angular.module('employeesMngApp', ['ui.router', 'ngMessages']);

employeesMngApp.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider

    	.state('home', {
	        url: '/home',
	        templateUrl: 'pages/home.html',
            controller: 'HomeController'
	    })
    
	    .state('users', {
	        abstract: true,
	        url: '/users',
	        template: '<ui-view/>'
	    })

	    .state('users.list', {
            url: '/list',
            templateUrl: 'pages/users.list.html',
            controller: 'UsersController'
        })
    
        .state('users.detail', {
            url: '/detail/:userId',
            templateUrl: 'pages/users.detail.html',
            controller: 'UserDetailController'
        })
        
        // nested list with custom controller
	    .state('home.list', {
	        url: '/list',
	        templateUrl: 'pages/partial-home-list.html',
	        controller: function($scope) {
	            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
	        }
	    })
	
	    // nested list with just some random string data
	    .state('home.paragraph', {
	        url: '/paragraph',
	        
	        template: 'I could sure use a drink right now.'
	    })
    
	    .state('about', {
	        url: '/about',
	        views: {

	            // the main template will be placed here (relatively named)
	            '': { 
	            	templateUrl: 'pages/partial-about.html',
                    controller: 'AboutController',
	            		
	            	},

	            // the child views will be defined here (absolutely named)
	            'columnOne@about': { template: 'Look I am a column!' },

	            // for column two, we'll define a separate controller 
	            'columnTwo@about': { 
	                templateUrl: 'pages/table-data.html',
	                controller: 'zzz'
	            }
	        }
	    })
	    
	    .state('error_page', {
	        url: '/error_page',
	        params: {
	        	errorDesc: '',
	        	escapePageState: '',
	        	buttonText: ''
	        },
	        templateUrl: 'pages/error_page.html',
	        controller: 'ErrorPageController'
	    });

});



//let's define the scotch controller that we call up in the about state
employeesMngApp.controller('zzz', function($scope) {
    
    $scope.message = 'test';
    
    $scope.scotches = [
        {
            name: 'Macallan 12',
            price: 50
        },
        {
            name: 'Chivas Regal Royal Salute',
            price: 10000
        },
        {
            name: 'Glenfiddich 1937',
            price: 20000
        }
    ];
    
});

