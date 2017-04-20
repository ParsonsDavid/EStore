angular.module('ShopApp', [
    'ui.router',
    'ShopApp.navbar',
    'ShopApp.RegisterController',
    'ShopApp.addProductController',
    'ShopApp.loginController',
    'ShopApp.viewProductsController',
    'ShopApp.adminController',
    'ShopApp.adminLoginController',
    'ShopApp.purchasesController',
    'ShopApp.productController'


]).config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/services');

    $stateProvider
        .state('register', {
            url: "/account/register",
            templateUrl: "resources/js/views/register.html",
            controller: 'RegisterController'
        })

        .state('specificProduct', {
            url: "/account/showProducts/:product",
            templateUrl: "resources/js/views/product.html",
            controller: 'productController'
        })


        .state('addProduct', {
            url: "/account/addProduct",
            templateUrl: "resources/js/views/addProduct.html",
            controller: 'addProductController'
        })


        .state('login', {
            url: "/account/login",
            templateUrl: "resources/js/views/login.html",
            controller: 'loginController'
        })


        .state('showProducts', {
            url: "/account/showProducts",
            templateUrl: "resources/js/views/showProducts.html",
            controller: 'viewProductsController'
        })


        .state('admin', {
            url: "/account/admin",
            templateUrl: "resources/js/views/admin.html",
            controller: 'adminController'
        })


        .state('adminLogin', {
            url: "/account/adminLogin",
            templateUrl: "resources/js/views/adminLogin.html",
            controller: 'adminLoginController'
        })


        .state('purchases', {
            url: "/account/purchases",
            templateUrl: "resources/js/views/showProducts.html",
            controller: 'purchasesController'
        });


});




