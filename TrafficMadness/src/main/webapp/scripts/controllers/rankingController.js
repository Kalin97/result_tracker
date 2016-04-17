gameStorageControllers.controller('rankingController', function ($scope, httpRest) {
	"use strict"

	$scope.apiUrl = "api/v1/playerRest/topPlayers/";

	httpRest.get($scope.apiUrl).success(function(players) {
		$scope.players = players;
	});
});