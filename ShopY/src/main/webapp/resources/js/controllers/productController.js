angular.module('ShopApp.productController', []).controller('productController', function ($scope, $stateParams, $http) {


    var title = $stateParams.title;
    console.log(title);
    $http.post('restful-services/api/getProductByTitle', title)
        .success(function (data, status) {
            $scope.product = data;


        })
        .error(function (error) {
            alert(error);
        });

});
