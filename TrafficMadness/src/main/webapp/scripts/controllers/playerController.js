gameStorageControllers.controller('playerController', function ($scope, $routeParams, Player) {
	"use strict"

	$scope.player = Player.get({ playerEmail: $routeParams.playerEmail }); 
});