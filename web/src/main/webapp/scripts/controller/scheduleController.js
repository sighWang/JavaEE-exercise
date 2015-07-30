angular.module('user_management')
.controller('scheduleController', function ($http, $scope, $location) {
        $http.get('api/schedules').
            success(function (data) {
                $scope.schedules = data;
                console.log(data);
            }).
            error(function () {

            });

        $scope.getUpdatePage = function (schedule) {
            $location.path('/scheduleUpdate/' + schedule.id);
        }
    });