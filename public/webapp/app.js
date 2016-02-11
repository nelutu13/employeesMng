'use strict'

var employeesMngApp = angular.module('employeesMngApp', ['ui.router', 'ngMessages', 'ui.bootstrap']);

employeesMngApp.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider

    	.state('home', {
	        url: '/home',
	        templateUrl: 'App/home/home.html',
            controller: 'HomeController'
	    })
    
	    .state('users', {
	        abstract: true,
	        url: '/users',
	        template: '<ui-view/>'
	    })

	    .state('users.list', {
            url: '/list/:pageNumber',
            templateUrl: 'App/users/usersList/users-list.html',
            controller: 'UsersListController'
        })
    
        .state('users.detail', {
            url: '/detail/:userId',
            templateUrl: 'App/users/userDetails/user-details.html',
            controller: 'UserDetailsController'
        })
    
        .state('users.create', {
            url: '/create',
            templateUrl: 'App/users/userDetails/user-details.html',
            controller: 'UserCreateController'
        })
        
        // nested list with custom controller
	    .state('home.list', {
	        url: '/list',
	        templateUrl: 'App/home/partial-home-list.html',
	        controller: function($scope) {
	            $scope.dogs = ['List users', 'Create users', 'Update users', 'Delete users', 'Pagination'];
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
	            	templateUrl: 'App/about/partial-about.html',
                    controller: 'AboutController',
	            		
	            	},

	            // the child views will be defined here (absolutely named)
	            'columnOne@about': { template: 'Look I am a column!' },

	            // for column two, we'll define a separate controller 
	            'columnTwo@about': { 
	                templateUrl: 'App/about/table-data.html',
	                controller: 'AboutController'
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
	        templateUrl: 'App/errorPage/error-page.html',
	        controller: 'ErrorPageController'
	    });

});
