angular.module('user_management').
    controller('scheduleUpdateController', function ($scope, $http, $routeParams) {
        
        $http.get('api/employees').
            success(function (data) {
                $scope.employees = data;

                $http.get('api/schedules/' + $routeParams.id).
                    success(function (schedule) {
                        $scope.updateSchedule = schedule;
                        data.forEach(function (employee, index) {
                            if (employee.id === schedule.course.employee.id) {
                                $scope.scheduleEmployee = data[index];
                            }
                        });
                    }).
                    error(function () {});
            }).
            error(function () {});
    });