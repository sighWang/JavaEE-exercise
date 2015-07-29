'use strict';
angular.module('user_management')
    .controller('listController', function ($scope, $http, $location) {
        $http.get('api/users').
            success(function (data) {
                $scope.users = data;
            }).
            error(function () {

            });

        $scope.updateUser = function (user) {
            console.log(user);
            $http.post('api/users/user/' + user.id).
                success(function (data) {

                }).
                error(function () {

                });

        };

        $scope.getUpdatePage = function (user) {
            console.log(user);
            $scope.user = user;
            $location.path("/userUpdate");
        }
    });