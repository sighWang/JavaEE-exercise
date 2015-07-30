'use strict';
angular.module('user_management')
    .controller('listController', function ($scope, $http, $location, $routeParams, userService) {
        $http.get('api/users').
            success(function (data) {
                $scope.users = data;
            }).
            error(function () {

            });

        $http.get('api/employees').
            success(function (data) {
                $scope.employees = data;
                $scope.addedUser = {employee: data[0]};
            }).
            error(function () {

            });
        //$scope.updateUser = userService.findUser();

        var id = $routeParams.userId;
        $http.get('api/users/user/' + id).
            success(function (data) {
                $scope.updateUser = data;
                //console.log($scope.updateUser);

            }).
            error(function () {

            });

        $scope.updateUser =
        $scope.updateUser = function (user) {
            console.log(user);
            $http.post('api/users/user/' + user.id).
                success(function (data) {

                }).
                error(function () {

                });
        };

        $scope.getUpdatePage = function (user) {
            userService.saveUser(user);
            $location.path("/userUpdate/"  + user.id);
        };

        $scope.deleteUser = function (user) {
            $http.delete('api/users/user/' + id).
                success(function (data) {

                }).
                error (function () {

                }
            )
        };

        $scope.getAddPage = function() {
            $location.path("/userAdd");
        };

        $scope.addUser = function(user) {
            console.log(user.employee);
            $http.post('api/users', user).
                success(function (data) {

                }).
                error(function () {

                });
        }
    });