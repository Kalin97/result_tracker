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
					"<img class='img-responsive' src='" + entry.image + "' alt=''>" +
					"</div><div class='col-md-5'><h3>" + entry.title + "</h3>" +
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
	
	function UpdateAndShowNewsPanel(newsInfo)
	{
		var rootElement = "#" + showNewsPanel + " ";
		
		var newsTitleElement   = $(rootElement + "#showNewsTitle");
		var newsAuthorElement  = $(rootElement + "#showNewsAuthor");
		var newsImageElement    = $(rootElement + "#showNewsImage");
		var newsContentElement = $(rootElement + "#showNewsContent");
		
 		newsTitleElement.text(newsInfo.title);
 		newsAuthorElement.text(newsInfo.administrator.email);
 		newsImageElement.attr("src", newsInfo.image);
 		newsContentElement.text(newsInfo.content);		
		
		showPanel(showNewsPanel);
	}
	
	function attachHandlers()
	{	
		$(document).on("click", "." + showNewsPanelElement, function() {
			var newsId = $(this).attr("data-news-id");
			
			getRequest(apiUrl + newsId).then(function(newsInfo) {
				UpdateAndShowNewsPanel(newsInfo);
			})			
		});

		$(document).on("click", ".backButton", function() {
			showPanel(showAllNewsPanel);
		});
	}
});