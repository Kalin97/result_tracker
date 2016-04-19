gameStorageApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
	when('/', {
		templateUrl: 'partials/news.html',
		controller: 'newsController'
	}).
	when('/news', {
		templateUrl: 'partials/news.html',
		controller: 'newsController'
	}).
	when('/player/:playerEmail', {
		templateUrl: 'partials/player.html',
		controller: 'playerController'
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
}]);