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

	    .state('home.list', {
	        url: '/list',
	        templateUrl: 'App/home/partial-home-list.html',
	        controller: function($scope) {
	            $scope.capabilities = ['List users', 'Create users', 'Update users', 'Delete users', 'Pagination'];
	        }
	    })

	    .state('home.desc', {
	        url: '/desc',
	        template: 'This app demonstrates the use of REST services using angular in fornt-end(the client) and java spring-boot on back-end(the server).'
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

        .state('users.details', {
            url: '/details/:userId',
            templateUrl: 'App/users/userDetails/user-details.html',
            controller: 'UserDetailsController'
        })

        .state('users.details.personal', {
            url: '/personal',
            templateUrl: 'App/users/userDetails/user-details-personal.html',
            controller: 'UserDetailsPersonalController'
        })

        .state('users.details.holidays', {
            url: '/holidays',
            templateUrl: 'App/users/userDetails/user-details-holidays.html',
            controller: 'UserDetailsHolidaysController'
        })

        .state('users.details.create', {
            url: '/create',
            templateUrl: 'App/users/userDetails/user-details-personal.html',
            controller: 'UserCreateController'
        })

	    .state('about', {
	        url: '/about',
	        views: {

	            '': {
	            	templateUrl: 'App/about/partial-about.html',
                    controller: 'AboutController'
            	},

	            'columnOne@about': { template: 'List of authors:' },

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
