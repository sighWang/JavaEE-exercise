'use strict';
angular.module('user_management')
    .controller('customerController', function ($scope, $http) {

        $http.get('api/customers').
            success(function (data) {
                $scope.customers = data;
            }).
            error(function () {

            });
    });