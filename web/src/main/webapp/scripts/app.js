'use strict';

angular
.module('user_management',['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
        //.when('/', {
        //    templateUrl: 'views/welcome.html',
        //    controller: 'WelcomeCtrl'
        //})
        .when('/views/users', {
            templateUrl: './views/users.html',
            controller: 'ListCtrl'
        })
    });