angular.module('user_management').
    controller('scheduleUpdateController', function ($scope, $http, $routeParams, $location) {

        $http.get('api/employees').
            success(function (data) {
                $scope.employees = data;

                $http.get('api/schedules/' + $routeParams.id).
                    success(function (schedule) {
                        $scope.updatedSchedule = schedule;
                        data.forEach(function (employee, index) {
                            if (employee.id === schedule.course.employee.id) {
                                $scope.updatedSchedule.employee = data[index];
                            }
                        });
                    }).
                    error(function () {});
            }).
            error(function () {});
        $scope.updateSchedule = function (schedule) {
            console.log(schedule);

            $http.post('api/schedules/' + schedule.id, schedule).
                success(function (data) {
                    console.log(data);
                    $location.path("schedules");
                }).
                error(function (data) {

                });
        }
    });