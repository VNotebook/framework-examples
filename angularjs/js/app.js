angular.module('movieApp', ['ngRoute'])
.config(function($routeProvider) {
	$routeProvider
		.when('/inicio', {
			templateUrl: 'views/main.html',
			controller: 'MainController'
		})
		.when('/acerca-de', {
			templateUrl: 'views/about.html',
			controller: 'AboutController'
		})
		.when('/crear', {
			templateUrl: 'views/editor.html',
			controller: 'EditorController'
		})
		.when('/editar/:movieId', {
			templateUrl: 'views/editor.html',
			controller: 'EditorController'
		})
		.otherwise({
	        redirectTo: '/inicio'
	    });
})
.factory('movieService', function() {
	return {
		movies: [
			{
				id: 0,
				title: "Harry potter y el prisionero de Azkaban",
				description: "bla bla asdfgthjsdfghj sdfghjsadfghj dfghjsadfghj ghjdsfghjmsdnfg ndfjgnsdedjfh sd fjsdfj sdnfsjdf nsddfh sdkfsdnd fjdsfnsdjfnseef hnckjmaskdf",
				genres: ["Novela", "Fantasía"],
				actors: ["Daniel Radcliffe", "Emma Watson", "Rupert Grint", "Gary Oldman"],
				date: "2004/05/23",
				director: "Alfonso Cuarón",
				imageUrl: "http://upload.wikimedia.org/wikipedia/en/b/bc/Prisoner_of_azkaban_UK_poster.jpg"
			},
			{
				id: 1,
				title: "The Matrix",
				description: "asdfgh bla asdfgthjsdfghj sdfghjsadfghj dfghjsadfghj ghjdsfghjmsdnfg ndfjgnsdedjfh sd fjsdfj sdnfsjdf nsddfh sdkfsdnd fjdsfnsdjfnseef hnckjmaskdf",
				genres: ["Ciencia ficción", "Acción"],
				actors: ["Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss", "Hugo Weaving"],
				date: "1999",
				director: "The Wachowskis",
				imageUrl: "http://upload.wikimedia.org/wikipedia/en/0/06/Ultimate_Matrix_Collection_poster.jpg"
			}

		],
		updateMovie: function(id, newValue) {
			if (id < 0 || id >= this.movies.length) {
				console.log("Invalid id");
				return;
			}
			newValue.id = id;
			this.movies[id] = newValue;
		},
		addMovie: function(movie) {
			movie.id = this.movies.length;
			this.movies.push(movie);
		},
		deleteMovie: function(id) {
			if (id < 0 || id >= this.movies.length) {
				console.log("Invalid id");
				return;
			}
			this.movies.splice(id, 1);

			for(var i = id; i < this.movies.length; ++i) {
				--this.movies[i].id;
			}
		}
	};
})
.controller('HeaderController', function($scope, $location) {
	$scope.isActive = function(location) {
    	return location.indexOf($location.path()) === 0;
    };
})
.controller('MainController', function($scope, movieService) {
	$scope.movies = movieService.movies;

	$scope.deleteMovie = function(id) {
		movieService.deleteMovie(id);
	};
})
.controller('EditorController', function($scope, $routeParams, $location, movieService) {
	var editingId = $routeParams.movieId;

	$scope.isEditing = editingId !== undefined && 0 <= editingId && 
						editingId < movieService.movies.length;
	if ($scope.isEditing) {
		$scope.oldItem = movieService.movies[editingId];
		$scope.item = angular.copy($scope.oldItem);
	} else {
		$scope.item = {
			title: "",
			description: "",
			genres: [],
			actors: [],
			date: "",
			director: "",
			imageUrl: ""
		};
	}

	$scope.save = function() {
		if ($scope.isEditing) {
			movieService.updateMovie(editingId, $scope.item);
		} else {
			movieService.addMovie($scope.item);
		}
		$location.path('/inicio');
	};

	$scope.genre = $scope.actor = "";
	
	$scope.addGenre = function() {
		$scope.item.genres.push($scope.genre);
		$scope.genre = "";
	};

	$scope.deleteGenre = function(index) {
		$scope.item.genres.splice(index, 1);
	};

	$scope.addActor = function() {
		$scope.item.actors.push($scope.actor);
		$scope.actor = "";
	};

	$scope.deleteActor = function(index) {
		$scope.item.actors.splice(index, 1);
	};
})
.controller('AboutController', function($scope) {

});