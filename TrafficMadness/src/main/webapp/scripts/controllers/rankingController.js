gameStorageApp.controller('rankingController', function ($scope, $http) {
	"use strict"

	$scope.apiUrl = "api/v1/playerRest/topPlayers";

	$http.get($scope.apiUrl).success(function(players) {
		$scope.players = players;
	});
});