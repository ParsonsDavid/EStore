
angular.module('ShopApp.link',[]).
directive('link', function ($http, $state) {
    return{
        restrict:'E',
        scope : {

        },

        controller:function ($scope) {
            $scope.goToAddProducts = function(){
                $state.go('addProduct');
            };

            $scope.goToRegister = function () {
                $state.go('register');
            };

            $scope.goToForm = function(){
                $state.go('allForm');
            };
        },
        templateUrl:'resources/js/views/register.html',
        transclude: false
    }
});
