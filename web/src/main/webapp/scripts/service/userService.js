angular.module('user_management')
    .service('userService', function UserService () {
        this.saveUser = function (user) {
            this.user = user;
        };

        this.findUser = function () {
            return this.user;
        };
    });