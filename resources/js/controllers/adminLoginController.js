
angular.module('ShopApp.adminLoginController',[]).
controller('adminLoginController', function ($scope, $http, $state) {

$scope.loginAdmin = function () {
    $http.post('restful-services/api/loginAdmin', JSON.stringify($scope.admin))
        .success(function (data, status) {
            if (status == 200) {
                $scope.admin = data;

                console.log($scope.admin, "Logged in admin");


            }
        }).error(function (error) {
        alert("not working");
    });

};
});