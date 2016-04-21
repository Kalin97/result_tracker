gameStorageControllers.controller('feedbackController', function ($scope, $routeParams, Feedback) {
	"use strict"

	// ----------------- Panels -----------------
	$scope.showFeedbackInfoPanel = "showFeedbackInfoPanel";
	$scope.editFeedbackInfoPanel = "editFeedbackInfoPanel";
	$scope.showAllFeedbacksPanel = "showAllFeedbacksPanel";
	// ----------------- Panels -----------------

	if($scope.authentication.isLoggedIn()) {
		if($routeParams.feedbackId == null) {
			$scope.panel = $scope.showAllFeedbacksPanel;
			$scope.feedbacks = Feedback.query();
		} else {
			$scope.panel = $scope.showFeedbackInfoPanel;
			$scope.feedback = Feedback.get({ feedbackId: $routeParams.feedbackId });
		}
	}

	$scope.createFeedback = function(newFeedback) {
		var feedback = new Feedback(newFeedback);

		feedback.$save(
			function() {
				$scope.setAlert(true, "You successfully created this feedback.");
				$scope.newFeedback = null;
			},
			function() {
				$scope.setAlert(false, "Wasn't able to created feedback successfully.");
			});
	}

	$scope.updateFeedback = function() {
		$scope.feedback.$update({ feedbackId: $scope.feedback.id },
			function() {
				$scope.setAlert(true, "You successfully updated this feedback.");
			},
			function() {
				$scope.setAlert(false, "Wasn't able to update feedback successfully.");
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