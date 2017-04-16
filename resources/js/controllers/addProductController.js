
angular.module('ShopApp.addProductController',[]).
controller('addProductController', function ($scope, $http, $state) {


    $scope.createProducts = function () {
        $http.post('/restful-services/api/createProduct', JSON.stringify($scope.product)).
        success(function (data, status) {
            if(status==200){
                console.log("Product Created");
                console.log($scope.product, 'This is the Product object');
                $state.go("register");
            }
        }).
        error(function (error) {
            console.log(error);
        });
    };





});