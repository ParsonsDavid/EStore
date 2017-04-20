angular.module('ShopApp.addProductController', []).controller('addProductController', function ($scope, $http, $state) {


    $scope.createProducts = function () {
        $http.post('/restful-services/api/createProduct', JSON.stringify($scope.product)).success(function (data, status) {
            if (status == 200) {
                console.log("new product");
                console.log($scope.product, 'product');
                $state.go("register");
            }
        }).error(function (error) {
            console.log(error);
        });
    };


    $scope.createPurchase = function () {
        $http.post('/restful-services/purchases/createPurchases', JSON.stringify($scope.purchase)).success(function (data, status) {
            if (status == 200) {
                $scope.purchase = data;
                console.log("Purchase added");
                console.log($scope.purchase, 'Purchase added');


            }
        }).error(function (error) {
            console.log(error);
        });
    };


});