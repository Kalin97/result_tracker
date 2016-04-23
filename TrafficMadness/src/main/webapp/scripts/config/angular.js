var gameStorageApp = angular.module('gameStorageApp', 
[
	'ngCookies',
	'ngRoute',
	'ngResource',
	'gameStorageControllers',
	'gameStorageServices'
]);

gameStorageApp.run(function($rootScope, $window, authentication) {
	$rootScope.authentication = authentication;

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