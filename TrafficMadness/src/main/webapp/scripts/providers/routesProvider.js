gameStorageApp.config(function($routeProvider) {
	$routeProvider.
	when('/', {
		templateUrl: 'partials/news.html',
		controller: 'newsController'
	}).
	when('/news', {
		templateUrl: 'partials/news.html',
		controller: 'newsController'
	}).
	when('/users/:playerEmail', {
		templateUrl: 'partials/users.html',
		controller: 'normalUserController'
	}).
	when('/login', {
		templateUrl: 'partials/login.html',
		controller: 'loginController'
	}).
	when('/ranking', {
		templateUrl: 'partials/ranking.html',
		controller: 'rankingController'
	}).
	otherwise({
		redirectTo: '/'
	});
});