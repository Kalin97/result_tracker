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

import org.trafficmadness.www.database.PlayersService;
import org.trafficmadness.www.user.entities.Player;

@Path("/playerRest")
public class PlayerRest 
{
	private final PlayersService playersService;
	
	@Inject
	public PlayerRest(PlayersService database)
	{
		this.playersService = database;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Player> getPlayerInfo()
	{
		return playersService.getData();
	}
	
	@GET
	@Path("/{playerEmail}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Player getPlayerInfoByEmail(@PathParam("playerEmail") String playerEmail)
	{
		return playersService.getDataByEmail(playerEmail);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Player postPlayerInfoByEmail(Player playerInfo)
	{
		return playersService.addData(playerInfo);
	}
	
	@PUT
	@Path("/{playerId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Player updatePlayerInfoByEmail(@PathParam("playerId") long playerId, Player playerInfo)
	{
		Player player = playersService.getData(playerId);
		player.setItems(playerInfo.getItems());
		player.setScore(playerInfo.getScore());
		
		return playersService.updateData(player);
	}
}
