angular.module('ShopApp.viewProductsController', []).controller('viewProductsController', function ($scope, $http, $state) {

    $http.get('restful-services/api/getAllProducts')
        .success(function (data, status) {
            $scope.products = data;
        })
        .error(function (error) {
            alert('An error occurred');
        });

    $scope.addProductToCart = function (product) {

        var purchase = {};
        purchase.product = product;
        purchase.paid = false;
        $http.post('/restful-services/purchases/addProductToPurchases', JSON.stringify(purchase)).success(function (data, status) {
            if (status == 200) {
                $scope.purchase = data;
                console.log("Purchase added");
                console.log($scope.purchase, 'Purchase added');
            }
        }).error(function (error) {
            console.log(error);
        });
    };

    $scope.createPurchases = function () {
        $http.post('/restful-services/purchases/createPurchase', JSON.stringify($scope.purchase)).success(function (data, status) {
            if (status == 200) {
                $scope.purchase = data;
                console.log("Purchase added");
                console.log($scope.purchase, 'Purchase added');

            }
        }).error(function (error) {
            console.log(error);
        });
    };


    $scope.showProducts = function (product) {
        console.log(product.title, 'PRODUCT');
        $state.go('specificProduct', {
            title: product.title
        })
    }

});

