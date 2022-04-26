angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadCart = function () {
        $http.get(contextPath + '/cart/all')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.delete = function (id){
        $http({
            url: contextPath + '/cart/delete',
            method: 'GET',
            params: {
                id: id,

            }
        }).then(function (response){
            $scope.loadCart();
        });
    };


    $scope.loadCart();

});