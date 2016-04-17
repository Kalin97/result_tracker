gameStorageControllers.controller('loginController', function ($scope) {
	"use strict"

	$scope.apiUrl = "api/v1/authentication/";
	$scope.redirectPage = "index.html";

	$scope.login = function(user) {
		$scope.authentication.login(user)
		.success(function() {
			$scope.setAlert(true, "You successfully logged in.");
			window.location.replace($scope.redirectPage);
		}).error(function() {
			$scope.setAlert(false, "Wasn't able to login successfully.");
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
});