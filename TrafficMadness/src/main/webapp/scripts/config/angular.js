var gameStorageApp = angular.module('gameStorageApp', 
[
	'ngCookies',
	'ngRoute',
	'ngResource',
	'gameStorageControllers',
	'gameStorageServices'
]);

gameStorageApp.run(function($rootScope, authentication) {
	$rootScope.authentication = authentication;
	$rootScope.reloadPage = function() { window.location.reload(); }
});

var gameStorageControllers = angular.module('gameStorageControllers', []);
var gameStorageServices = angular.module('gameStorageServices', []);