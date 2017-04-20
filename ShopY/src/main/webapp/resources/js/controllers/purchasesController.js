angular.module('ShopApp.purchasesController', []).controller('purchasesController', function ($scope, $http, $state) {

    $scope.createPurchase = function () {
        $http.post('/restful-services/purchases/createPurchases', JSON.stringify($scope.purchase)).success(function (data, status) {
            if (status == 200) {
                $scope.purchase = data;
                console.log("Purchased");
                console.log($scope.purchase, 'Purchased');


            }
        }).error(function (error) {
            console.log(error);
        });
    };


});






