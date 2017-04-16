angular.module('ShopApp.RegisterController',[]).
    controller('RegisterController', function ($scope, $http, $state) {

        $scope.registerUser = function () {
            $http.post('/restful-services/api/createUser', JSON.stringify($scope.user)).
                success(function (data, status) {
                    if(status==200){
                        $scope.user = data;
                        console.log("User Created");
                        console.log($scope.user, 'This is the user object');

                        $state.go("login");

                    }
                }).
                error(function (error) {
                    console.log(error);
            });
        };








});