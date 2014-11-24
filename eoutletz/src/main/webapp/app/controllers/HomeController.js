'use strict';

define(['app'], function(app) {
	app.register.controller('HomeController', ['$scope', 
		function($scope) {
			$scope.title="Home Page";
		
		}
	]);
});