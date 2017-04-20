angular.module('ShopApp.loginController', []).controller('loginController', function ($scope, $http, $state) {


    $scope.loginUser = function () {
        $http.post('/restful-services/hello/loginUser', JSON.stringify($scope.userLogin)).success(function (data, status) {
            if (status == 200) {
                $scope.userLogin = data;
                console.log("Logged in");
                console.log($scope.userLogin, 'User');

                $state.go("showProducts");
            }
        }).error(function (error) {
            console.log(error);
        });
    };


});
