gameStorageControllers.controller('loginController', function ($scope, $http, facebook, httpRest, AUTH_ROLES) {
	"use strict"

	$scope.headAdminServerString = "HEAD";
	$scope.apiUrl = "api/v1/authentication/";
	$scope.facebookAuthUri = "api/v1/facebookAuthentication/";
	$scope.redirectPage = "index.html";

	$scope.login = function(user) {
		httpRest.post($scope.apiUrl, user)
		.success(function(loggedInUser) {
			var role = loggedInUser.administratorType == $scope.headAdminServerString ? AUTH_ROLES.HeadAdmin : AUTH_ROLES.Admin;
			$scope.authentication.login(loggedInUser.email, role);

			$scope.setAlert(true, "You successfully logged in.");
			window.location.replace($scope.redirectPage);
		}).error(function() {
			$scope.setAlert(false, "Wasn't able to login successfully.");
		});
	}

	$scope.loginWithFacebook = function() {
		facebook.getUserEmail().then(function(userEmail) {
			$http.post($scope.facebookAuthUri, userEmail)
			.success(function(loggedInUser) {
				$scope.authentication.login(loggedInUser.player.email, AUTH_ROLES.User);

				$scope.setAlert(true, "You successfully logged in.");
				window.location.replace($scope.redirectPage);
			}).error(function() {
				$scope.setAlert(false, "Wasn't able to login successfully.");
			});
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