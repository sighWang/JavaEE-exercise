angular.module('user_management')
.controller('scheduleController', function ($http, $scope) {
        $http.get('api/schedules').
            success(function (data) {
                $scope.schedules = data;
                console.log(data);
            }).
            error(function () {

            })
    });