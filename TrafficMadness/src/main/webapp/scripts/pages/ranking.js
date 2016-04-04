$(document).ready(function() {
	"use strict"
	
	var apiUrl = "api/v1/playerRest/topPlayers";
	var topPlayersTableBody = "topPlayersTableBody";
	
	getRequest(apiUrl).then(function(players) {
		_.forEach(players, function(player, index) {
			var playerNumber = parseInt(index) + 1;
			var playerHtml =
				"<tr>" +
					"<th scope='row'>" + playerNumber + "</th>" +
					"<td>" + player.name  + "</td>" +
					"<td>" + player.email + "</td>" +
					"<td>" + player.score + "</td>" +
				"</tr>";
				
				
			$("#" + topPlayersTableBody).append(playerHtml);
		});
	});
});