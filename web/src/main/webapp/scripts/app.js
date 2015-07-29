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
            controller: 'ListCtrl'
        })
            .when('/customers', {
            templateUrl: './views/customers.html',
                controller: 'customerController'
        })
    });