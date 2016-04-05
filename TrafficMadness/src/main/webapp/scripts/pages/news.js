$(document).ready(function() {
	"use strict"
	
	var apiUrl = "api/v1/news/";
	var editNewsPanel = "editNewsPanel";
	var editNewsPanelAlertElement = "editNewsPanelAlertElement";
	var createNewsPanel = "createNewsPanel";
	var createNewsPanelAlertElement = "createNewsPanelAlertElement";
	var showAllNewsPanel = "showAllNewsPanel";
	var showNewsPanel = "showNewsPanel";
	var showNewsPanelElement = "showNewsPanelElement";
	var maxContentLength = 200;
	
	attachHandlers();
	
	getRequest(apiUrl).then(function(response) {
		_.forEach(response.reverse(), function(entry) {
			var entryHtml = "<div class='row'><div class='col-md-7'>" +
					"<img class='img-responsive' src='" + entry.image + "' alt=''>" +
					"</div><div class='col-md-5'><h3>" + entry.title + "</h3>" +
					"<h4>" + entry.administrator.email + "</h4>" +
					"<p>" + entry.content.substring(0, maxContentLength) + "</p>" +
					"<button class='btn btn-primary " + showNewsPanelElement + "' data-news-id='" + entry.id + "'>More Info <span class='glyphicon glyphicon-chevron-right'></span></button></div></div><hr>";

			$("#" + showAllNewsPanel).prepend(entryHtml);
		});
	});
	
	function showPanel(panelName) 
	{
		var ALL_PANELS = [showAllNewsPanel, showNewsPanel, createNewsPanel, editNewsPanel];
		_.forEach(ALL_PANELS, function(nextValue) {
			$("#" + nextValue).hide();
		});
		
		$("#" + panelName).show();
	}
	
	function updateAndShowNewsPanel(newsInfo)
	{
		var rootElement = "#" + showNewsPanel + " ";
		
		var newsTitleElement   = $(rootElement + "#showNewsTitle");
		var newsAuthorElement  = $(rootElement + "#showNewsAuthor");
		var newsImageElement   = $(rootElement + "#showNewsImage");
		var newsContentElement = $(rootElement + "#showNewsContent");
		
 		newsTitleElement.text(newsInfo.title);
 		newsAuthorElement.text(newsInfo.administrator.email);
 		newsImageElement.attr("src", newsInfo.image);
 		newsContentElement.text(newsInfo.content);		
 		
 		$("input[name='editNewsPanelImage']").val(newsInfo.image);
		$("input[name='editNewsPanelTitle']").val(newsInfo.title);
		$("textarea[name='editNewsPanelContent']").val(newsInfo.content);
		$("#sendUpdateNewsButton").attr("data-news-id", newsInfo.id);
		$("#deleteNewsButton").attr("data-news-id", newsInfo.id);
		
		showPanel(showNewsPanel);
	}
	
	function submitNews()
	{
		var imageVal   = $("input[name='createNewsPanelImage']").val();
		var titleVal   = $("input[name='createNewsPanelTitle']").val();
		var contentVal = $("textarea[name='createNewsPanelContent']").val();
		
		var jsonData = {
			title: titleVal,
			image: imageVal,
			content: contentVal
		};
		
		var request = postRequest(apiUrl, jsonData);

		request.success(function() {
			$("#" + createNewsPanelAlertElement).html(
				"<div class='alert alert-success' " +
				"role='alert'>" +
				"You successfully created this news." +
				"</div>");
			
			$("input[name='createNewsPanelImage']").val("");
			$("input[name='createNewsPanelTitle']").val("");
			$("textarea[name='createNewsPanelContent']").val("");
		});
		
		request.error(function() {
			$("#" + createNewsPanelAlertElement).html(
				"<div class='alert alert-danger' " +
				"role='alert'>" +
				"Wasn't able to create news successfully." +
				"</div>");
		});
	}
	
	function updateNews()
	{
		var newsId 	   = $("#sendUpdateNewsButton").attr("data-news-id");
		var imageVal   = $("input[name='editNewsPanelImage']").val();
		var titleVal   = $("input[name='editNewsPanelTitle']").val();
		var contentVal = $("textarea[name='editNewsPanelContent']").val();
		
		var jsonData = {
			title: titleVal,
			image: imageVal,
			content: contentVal
		};
		
		var request = putRequest(apiUrl + newsId, jsonData);

		request.success(function() {
			$("#" + editNewsPanelAlertElement).html(
				"<div class='alert alert-success' " +
				"role='alert'>" +
				"You successfully updated this news." +
				"</div>");
		});
		
		request.error(function() {
			$("#" + editNewsPanelAlertElement).html(
				"<div class='alert alert-danger' " +
				"role='alert'>" +
				"Wasn't able to update news successfully." +
				"</div>");
		});
	}
	
	function deleteNews()
	{
		if(confirm("Are you sure you want to delete this news?") == false)
		{
			return;
		}
		
		var newsId = $("#deleteNewsButton").attr("data-news-id");
		
		var request = deleteRequest(apiUrl + newsId);

		request.success(function() {
			location.reload();
		});
		
		request.error(function() {
			$("#" + editNewsPanelAlertElement).html(
				"<div class='alert alert-danger' " +
				"role='alert'>" +
				"Wasn't able to update news successfully." +
				"</div>");
		});
		
	}
	
	function attachHandlers()
	{	
		$(document).on("click", "." + showNewsPanelElement, function() {
			var newsId = $(this).attr("data-news-id");
			
			getRequest(apiUrl + newsId).then(function(newsInfo) {
				updateAndShowNewsPanel(newsInfo);
			})			
		});

		$(document).on("click", "#createNewsButton", function() {
			$("#" + createNewsPanelAlertElement).html("");
			
			showPanel(createNewsPanel);
		});
		
		$(document).on("click", "#editNewsButton", function() {
			$("#" + createNewsPanelAlertElement).html("");
			
			showPanel(editNewsPanel);
		});
		
		$(document).on("click", "#sendCreateNewsButton", function() {
			submitNews();
		});
		
		$(document).on("click", "#sendUpdateNewsButton", function() {
			updateNews();
		});
		
		$(document).on("click", "#deleteNewsButton", function() {
			deleteNews();
		});

		$(document).on("click", ".backButton", function() {
			showPanel(showAllNewsPanel);
		});
	}
});