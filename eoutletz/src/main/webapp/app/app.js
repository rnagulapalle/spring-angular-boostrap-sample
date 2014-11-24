define(['require', 'angular', 'angular-ui.router', 'routeResolver'] , function (require, angular) {
	'use strict';
	
	var app = angular.module('eoutletzApp', ['ngRoute', 'routeResolverServices']);
	
	app.init = function () {
		if(document.readyState === 'interactive' || document.readyState === 'complete') {
			angular.bootstrap(document, ['eoutletzApp']);
			//log(app);
		}
		else {
			document.onreadystatechange = function () {
				if(document.readyState === 'interactive') {
					angular.bootstrap(document, ['eoutletzApp']);
				}
			}
		}
	};
	
	
	app.config(['$routeProvider', '$locationProvider', '$controllerProvider', 'routeResolverProvider', 
		function ($routeProvider, $locationProvider, $controllerProvider, routeResolverProvider) {
			var route = routeResolverProvider.route;
			
			//app.controller = $controllerProvider.register;
			//app.router = $routeProvider;
			
			app.register = {
				controller : $controllerProvider.register,
				location : $locationProvider.register
			};
			$routeProvider
				.when('/', route.resolve('Home'))
				.otherwise({redirectTo: '/'});
			
		}
	]);

	app.controller('MenuController', function ($scope) {
		$scope.items = [
			{itemId : '1', title : 'Home', href: 'home'},
			{itemId : '2', title : 'Catalogue', href: 'catalogue'},
			{itemId : '3', title : 'Shopping Cart', href: 'cart'},
			{itemId : '4', title : 'Checkout', href: 'checkout'},
			{itemId : '5', title : 'Pages', href: '', sublinks : [
				{itemId : '5-1', title : 'About Us', href : 'aboutus'},
				{itemId : '5-2', title : 'Contact Us', href : 'contactus'}
			]}
		];
		
		// Defaults
	    $scope.sublinks = null;
    	$scope.activeItem = null;
    	
    	 /*
     	  * Set active item and submenu links
	      */
    	$scope.showMenu = function(item, pos) {
    	    // Set activeItem and sublinks to the currectly
        	// selected item.
	        $scope.activeItem = item;
    	    $scope.sublinks = item.sublinks;
    	};
	
	});
	
	return app;

});