gameStorageControllers.controller('normalUserController', function ($scope, $routeParams, NormalUser) {
	"use strict"

	// ----------------- Panels -----------------
	$scope.showUserInfoPanel = "showUserInfoPanel";
	$scope.editUserInfoPanel = "editUserInfoPanel";
	// ----------------- Panels -----------------

	$scope.panel = $scope.showUserInfoPanel;
	$scope.user = NormalUser.getByEmail({ playerEmail: $routeParams.playerEmail });

	$scope.updateUser = function() {
		$scope.user.$update({ userId: $scope.user.id },
			function() {
				$scope.setAlert(true, "You successfully updated this user.");
			},
			function() {
				$scope.setAlert(false, "Wasn't able to update user successfully.");
			});
	}

	$scope.deleteUser = function() {
		$scope.user.$delete({ userId: $scope.user.id },
			function() {
				window.location.href='#/ranking';
			});
	}

	$scope.setAlert = function(isSuccessful, message) {
		$scope.alertBoxType = isSuccessful ? "success" : "danger";
		$scope.alertBoxMessage = message;
		$scope.alertBoxShow = true;
	}

	$scope.disableAlert = function() {
		$scope.alertBoxShow = false;
	}

	$scope.showPanel = function(panelName) {
		$scope.panel = panelName;
	}

	$scope.ifActive = function(panelName) {
		return $scope.panel == panelName;
	}
});