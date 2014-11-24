/**
 * Base Controller
 **/ 

define(['angular', 'HomeController'], 
 	function (angular, HomeController) {
 		
 		var controllers = angular.module('controllers', []);

 		controllers.controller('HomeController', HomeController);

 		return controllers;
});