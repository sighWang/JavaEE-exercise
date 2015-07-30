'use strict';

angular
.module('user_management',['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
        //.when('/', {
        //    templateUrl: 'views/welcome.html',
        //    controller: 'WelcomeCtrl'
        //})
        .when('/users', {
            templateUrl: './views/users.html',
            controller: 'listController'
        })
            .when('/customers', {
            templateUrl: './views/customers.html',
                controller: 'customerController'
        })
            .when('/userUpdate/:userId', {
                templateUrl: './views/userUpdate.html',
                controller: 'listController'
            })
            .when('/userAdd', {
                templateUrl: './views/userAdd.html',
                controller: 'listController'
            })
            .when('/schedules', {
                templateUrl: './views/schedules.html',
                controller: 'scheduleController'
            })
            .when('/scheduleUpdate/:id', {
                templateUrl : './views/scheduleUpdate.html',
                controller: 'scheduleUpdateController'
            })
    });