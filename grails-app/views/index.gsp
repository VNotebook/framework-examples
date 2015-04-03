<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Películas</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.min.css">
	</head>
	<body data-ng-app="moviesApp">
		<div data-ng-controller="HeaderController">
			<nav class="navbar navbar-default navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#/">Películas</a>

					</div>
					<ul class="nav navbar-nav">
						<li data-ng-class="{active: isActive('/inicio')}"><a href="#/inicio">Películas</a></li>
						<li data-ng-class="{active: isActive('/actores')}"><a href="#/actores">Actores</a></li>
						<li data-ng-class="{active: isActive('/generos')}"><a href="#/generos">Géneros</a></li>
					</ul>
				</div>
			</nav>
		</div>

		<div class="container">
			<div data-ng-view></div>
		</div>

		<script src="js/angular.min.js"></script>
		<script src="js/angular-route.min.js"></script>
		<script src="js/index.js"></script>
	</body>
</html>
