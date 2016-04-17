var gameStorageApp = angular.module('gameStorageApp', ['ngCookies', 'ngRoute', 'gameStorageControllers']);

gameStorageApp.run(function($rootScope, authentication) {
	$rootScope.authentication = authentication;
	$rootScope.reloadPage = function() { window.location.reload(); }
});

var gameStorageControllers = angular.module('gameStorageControllers', []);