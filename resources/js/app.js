angular.module('ShopApp', [
    'ui.router',
    'ShopApp.navbar',
    'ShopApp.RegisterController',
    'ShopApp.addProductController',
    'ShopApp.loginController',
    'ShopApp.viewProductsController',
    'ShopApp.adminController',
    'ShopApp.adminLoginController'


]).config(function ($stateProvider) {

    $stateProvider
        .state('register', {
            url: "/account/register",
            templateUrl: "resources/js/views/register.html",
            controller: 'RegisterController'
        });

    $stateProvider
        .state('addProduct', {
            url: "/account/addProduct",
            templateUrl: "resources/js/views/addProduct.html",
            controller: 'addProductController'
        });

    $stateProvider
        .state('login', {
            url: "/account/login",
            templateUrl: "resources/js/views/login.html",
            controller: 'loginController'
        });

    $stateProvider
        .state('showProducts', {
            url: "/account/showProducts",
            templateUrl: "resources/js/views/showProducts.html",
            controller: 'viewProductsController'
        });

    $stateProvider
        .state('admin', {
            url: "/account/admin",
            templateUrl: "resources/js/views/admin.html",
            controller: 'adminController'
        });

    $stateProvider
        .state('adminLogin', {
            url: "/account/adminLogin",
            templateUrl: "resources/js/views/adminLogin.html",
            controller: 'adminLoginController'
        });


});




