$(document).ready(function() {
	"use strict"
	
	var apiUrl = "api/v1/news/";
	var showAllNewsPanel = "showAllNewsPanel";
	var showNewsPanel = "showNewsPanel";
	var showNewsPanelElement = "showNewsPanelElement";
	var maxContentLength = 200;
	
	attachHandlers();
	
	getRequest(apiUrl).then(function(response) {
		_.forEach(response, function(entry) {
			var entryHtml = "<div class='row'><div class='col-md-7'>" +
					"<a href='#'>" +
					"<img class='img-responsive' src='" + entry.image + "' alt=''>" +
					"</a></div><div class='col-md-5'><h3>" + entry.title + "</h3>" +
					"<h4>" + entry.administrator.email + "</h4>" +
					"<p>" + entry.content.substring(0, maxContentLength) + "</p>" +
					"<button class='btn btn-primary " + showNewsPanelElement + "' data-news-id='" + entry.id + "'>More Info <span class='glyphicon glyphicon-chevron-right'></span></button></div></div><hr>";

			$("#" + showAllNewsPanel).append(entryHtml);
		});
	});
	
	function showPanel(panelName) 
	{
		var ALL_PANELS = [showAllNewsPanel, showNewsPanel];
		_.forEach(ALL_PANELS, function(nextValue) {
			$("#" + nextValue).hide();
		});
		
		$("#" + panelName).show();
	}
	
	function showNews(newsId)
	{
		showPanel(showNewsPanel);
	}
	
	function attachHandlers()
	{	
		$(document).on("click", "." + showNewsPanelElement, function() {
			var newsId = $(this).attr("data-news-id");
			
			showNews(newsId);
		});

		$(document).on("click", ".backButton", function() {
			showPanel(showAllNewsPanel);
		});
	}
});