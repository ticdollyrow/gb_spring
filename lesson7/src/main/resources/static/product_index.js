angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.productList = response.data;
                console.log($scope.productList);
            });
    };

    $scope.loadProductsPage = function () {
        $http.get(contextPath + '/products_page')
        .then(function (response) {
            $scope.productList = response.data;
        });
    };

    $scope.createProductJson = function (){
        console.log($scope.newProductJson);
        $http.post(contextPath + '/products', $scope.newProductJson)
            .then(function (response) {
                $scope.loadProducts()
            });
    }

    $scope.filterProduct = function (){
        console.log($scope.filter)
        $http({
            url: contextPath + "/products/filter",
            method: 'get',
            params: {
                min: $scope.filter.min,
                max: $scope.filter.max
            }
        }).then(function (response){
            $scope.productList = response.data;
        })
    }


    $scope.loadProducts();

});