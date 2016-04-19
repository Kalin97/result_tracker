gameStorageControllers.controller('newsController', function ($scope, News) {
	"use strict"

	$scope.maxContentLength = 200;
	$scope.alertBoxShow = false;

	// ----------------- Panels -----------------
	$scope.showAllNewsPanel = "showAllNewsPanel";
	$scope.showNewsPanel = "showNewsPanel";
	$scope.createNewsPanel = "createNewsPanel";
	$scope.editNewsPanel = "editNewsPanel";
	// ----------------- Panels -----------------

	$scope.panel = $scope.showAllNewsPanel;

	$scope.allNews = News.query();

	$scope.updateNews = function() {
		$scope.currentNews.$update({ newsId: $scope.currentNews.id },
			function() {
				$scope.setAlert(true, "You successfully updated this news.");
			},
			function() {
				$scope.setAlert(false, "Wasn't able to update news successfully.");
			});
	}

	$scope.deleteNews = function() {
		$scope.currentNews.$delete({ newsId: $scope.currentNews.id },
			function() {
				location.reload();
			});
	}

	$scope.createNews = function(newNewsArg) {
		var newNews = new News(newNewsArg);
		newNews.$save(
			function() {
				$scope.setAlert(true, "You successfully created this news.");
				$scope.currentNews = newNews;
				location.reload();
			}, 
			function() {
				$scope.setAlert(false, "Wasn't able to create news successfully.");
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

	$scope.showNewsWithId = function(newsId) {
		$scope.currentNews = News.get({ newsId: newsId }, function() {
			$scope.showPanel($scope.showNewsPanel);
		});
	}

	$scope.showPanel = function(panelName) {
		$scope.panel = panelName;
	}

	$scope.ifActive = function(panelName) {
		return $scope.panel == panelName;
	}
});