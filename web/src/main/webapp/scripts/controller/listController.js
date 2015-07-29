'use strict';
angular.module('user_management')
    .controller('ListCtrl', function ($scope, $http) {
        $http.get('api/users').
            success(function (data) {
                $scope.users = data;
            }).
            error(function () {

            });
    });