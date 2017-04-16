
angular.module('ShopApp.loginController',[]).
controller('loginController', function ($scope, $http, $state) {



    $scope.loginUser = function () {
        $http.post('/restful-services/hello/loginUser', JSON.stringify($scope.userLogin)).
        success(function (data, status) {
            if(status==200){
                $scope.userLogin = data;
                console.log("User Created");
                console.log($scope.userLogin, 'This is the user object');

                $state.go("addProduct");
            }
        }).
        error(function (error) {
            console.log(error);
        });
    };







});
