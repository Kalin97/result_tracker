gameStorageControllers.controller('newsController', function ($scope, httpRest) {
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

	httpRest.get($scope.apiUrl).success(function(allNews) {
		$scope.allNews = allNews;
	});

	$scope.showNewsWithId = function(newsId) {
		httpRest.get($scope.apiUrl + newsId).success(function(currentNews) {
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
		httpRest.put($scope.apiUrl + $scope.currentNews.id, news)
		.success(function() {
			$scope.setAlert(true, "You successfully updated this news.");
		}).error(function() {
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

	$scope.deleteNews = function(newsId) {
		httpRest.delete($scope.apiUrl + newsId).success(function() {
			location.reload();
		});
	}

	$scope.createNews = function(newNews) {
		httpRest.post($scope.apiUrl, newNews)
		.success(function() {
			$scope.setAlert(true, "You successfully created this news.");
			$scope.currentNews = newNews;
			location.reload();
		}).error(function() {
			$scope.setAlert(false, "Wasn't able to create news successfully.");
		});
	}
});