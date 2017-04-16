
angular.module('ShopApp.adminController',[]).
controller('adminController', function ($scope, $http, $state) {

    $scope.addAdmin = function () {
    $http.post('restful-services/api/addAdmin', JSON.stringify($scope.admin))
        .success(function (data, status) {
            if (status == 200) {
                $scope.admin = data;
                console.log("Admin Created");
                console.log($scope.admin, "Admin added");
                $state.go("addProduct");
            }
        }).error(function (error) {
        alert("not working");
    });
    };








});












