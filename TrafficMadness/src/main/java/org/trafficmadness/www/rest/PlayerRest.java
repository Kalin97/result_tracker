package org.trafficmadness.www.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.trafficmadness.www.database.PlayerService;
import org.trafficmadness.www.user.entities.Player;

@Path("/playerRest")
public class PlayerRest 
{
	private final PlayerService playerService;
	
	@Inject
	public PlayerRest(PlayerService database)
	{
		this.playerService = database;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Player> getPlayerInfo()
	{
		return playerService.getData();
	}
	
	@GET
	@Path("/{playerEmail}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Player getPlayerInfoByEmail(@PathParam("playerEmail") String playerEmail)
	{
		return playerService.getDataByEmail(playerEmail);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void postPlayerInfoByEmail(Player playerInfo)
	{
		playerService.addData(playerInfo);
	}
	
	@PUT
	@Path("/{playerId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void updatePlayerInfoByEmail(@PathParam("playerId") long playerId, Player playerInfo)
	{
		Player player = playerService.getData(playerId);
		player.setItems(playerInfo.getItems());
		player.setScore(playerInfo.getScore());
		
		playerService.updateData(player);
	}
}
