gameStorageApp.controller('newsController', function ($scope, $http) {
	"use strict"

	$scope.apiUrl = "api/v1/news/";
	$scope.maxContentLength = 200;
	$scope.alertBoxShow = false;

	// ----------------- Panels -----------------
	$scope.showAllNewsPanel = "showAllNewsPanel";
	$scope.showNewsPanel = "showNewsPanel";
	$scope.createNewsPanel = "createNewsPanel";
	$scope.editNewsPanel = "editNewsPanel";
	// ----------------- Panels -----------------

	$scope.panel = $scope.showAllNewsPanel;

	$http.get($scope.apiUrl).success(function(allNews) {
		$scope.allNews = allNews;
	});

	$scope.showNewsWithId = function(newsId) {
		$http.get($scope.apiUrl + newsId).success(function(currentNews) {
			$scope.currentNews = currentNews;

			$scope.showPanel($scope.showNewsPanel);
		});
	}

	$scope.showPanel = function(panelName) {
		$scope.panel = panelName;
	}

	$scope.ifActive = function(panelName) {
		return $scope.panel == panelName;
	}

	$scope.updateNews = function(news) {
		$http({
			url: $scope.apiUrl + $scope.currentNews.id,
			dataType: 'json',
			method: 'PUT',
			data: news,
			headers: {
			"Content-Type": "application/json"
			}
		}).success(function(response) {
			$scope.setAlert(true, "You successfully updated this news.");
		}).error(function(error) {
			$scope.setAlert(false, "Wasn't able to update news successfully.");
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