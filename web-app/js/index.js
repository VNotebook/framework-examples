'use strict';

var as = angular.module('moviesApp', ['ngRoute'])
    .config(function($routeProvider) {
        $routeProvider
            .when('/editarGenero/:genreId', {
                templateUrl: 'html/genres/editGenre.html',
                controler: 'GenreEditCtrl'
            })
            .when('/generos', {
                templateUrl: 'html/genres/genreIndex.html',
                controller: 'GenreListCtrl'
            })
            .when('/nuevoGenero', {
                templateUrl: 'html/genres/createGenre.html',
                controller: 'NewGenreCtrl'
            })
            .otherwise({
                redirectTo: '/generos'
            });
    });

as.controller('HeaderController', function($scope, $location) {
    $scope.isActive = function(location) {
        return location.indexOf($location.path()) === 0;
    };
});

as.controller('EditGenreCtrl', function($scope, $rootScope, $http, $routeParams, $location) {

    var load = function() {
        var id = $routeParams.genreId.replace(':', '');
        $http.get('http://localhost:8080/framework-examples/generos/' + id + '.json')
            .success(function(data, status, headers, config) {
                $scope.genre = data;
                angular.copy($scope.genre, $scope.copy);
            });
    }

    load();

    $scope.genre = {};

    $scope.updateGenre = function() {
        $http
            .put(' http://localhost:8080/framework-examples/generos/' + $scope.genre.id + '.json',  $scope.genre)
            .success(function(data, status, headers, config) {
                $location.path('/generos');
            }).error(function(data, status, headers, config) {
            });
    }
});

as.controller('GenreListCtrl', function($scope, $rootScope, $http, $location) {
    var load = function() {
        $http.get('http://localhost:8080/framework-examples/generos.json')
            .success(function(data, status, headers, config) {
                $scope.genres = data;
            });
    };

    load();

    $scope.addGenre = function() {
        $location.path('/nuevoGenero');
    };

    $scope.editGenre = function(index) {
        var toEdit = $scope.genres[index].id;
        $location.path('/editarGenero/:' + toEdit);
    };

    $scope.delGenre = function(index) {
        var toDelete = $scope.genres[index].id;
        $http
            .delete('http://localhost:8080/framework-examples/generos/' + toDelete +  '.json')
            .success(function(data, status, headers, config) {
                load();
            }).error(function(data, status, headers, config) {
            });
    };

});

as.controller('NewGenreCtrl', function($scope, $rootScope, $http, $location) {
    $scope.genre = {movies: [], name: ''};

    $scope.saveGenre = function() {
        $http
            .post('http://localhost:8080/framework-examples/generos.json', $scope.genre)
            .success(function(data, status, headers, config) {
                $location.path('/generos');
            }).error(function(data, status, headers, config) {
            });
    };
});