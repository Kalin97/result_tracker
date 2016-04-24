var gameStorageApp = angular.module('gameStorageApp', 
[
	'ngCookies',
	'ngRoute',
	'ngResource',
	'gameStorageControllers',
	'gameStorageServices'
]);

gameStorageApp.constant("AUTH_ROLES", {
	HEAD_ADMIN: 0,
	ADMIN: 1,
	USER: 2
});

gameStorageApp.run(function($rootScope, $window, authentication, AUTH_ROLES) {
	$rootScope.authentication = authentication;
	$rootScope.AUTH_ROLES = AUTH_ROLES;

	$rootScope.reloadPage = function() { window.location.reload(); }

	$window.fbAsyncInit = function() {
		FB.init({ 
			appId: '1600075400307802',
			xfbml: true,
			version: 'v2.6'
		});
	};
});

var gameStorageControllers = angular.module('gameStorageControllers', []);
var gameStorageServices = angular.module('gameStorageServices', []);