gameStorageControllers.controller('rankingController', function ($scope, Player) {
	"use strict"

	$scope.players = Player.query();
});