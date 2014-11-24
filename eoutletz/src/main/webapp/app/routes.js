define(['app'], function (app) {

	return app.config(['$routeProvider', '$locationProvider', '$controllerProvider', 
		function ($routeProvider, $locationProvider, $controllerProvider) {
			$routeProvider.when('/', {templateUrl : 'app/views/home.html', controller : 'HomeController'}).otherwise({redirectTo: '/'});
			//app.controller = $controllerProvider;
			//app.router = $routeProvider;
		}
	]);
});