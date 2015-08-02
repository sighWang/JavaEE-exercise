angular.module('user_management')
.controller('scheduleController', function ($http, $scope, $location) {
        $http.get('api/schedules').
            success(function (data) {
                $scope.schedules = data;
                console.log(data);
            }).
            error(function () {

            });
        $http.get('api/courses').
            success(function (data) {
                $scope.courses = data;
            }).
            error(function () {

            });
        $http.get('api/customers').
            success(function (data) {
                $scope.customers = data;
            }).
            error(function () {

            });
        $scope.getUpdatePage = function (schedule) {
            $location.path('/scheduleUpdate/' + schedule.id);
        };

        $scope.getAddPage = function () {
          $location.path('/scheduleAdd');
        };

        $scope.addSchedule = function (scheduel) {
            var date = scheduel.date;
            scheduel.date = date.toISOString().substring(0,10);
            console.log(scheduel);

            $http.post('api/schedules',scheduel).
                success(function() {

                }).
                error(function () {

                });
        }

    });