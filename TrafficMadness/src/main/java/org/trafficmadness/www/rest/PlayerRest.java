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

import org.trafficmadness.www.services.PlayersService;
import org.trafficmadness.www.user.entities.NormalUser;
import org.trafficmadness.www.user.entities.Player;

@Path("/playerRest")
public class PlayerRest 
{
	private final PlayersService playersService;
	
	@Inject
	public PlayerRest(PlayersService playersService)
	{
		this.playersService = playersService;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Player> getPlayers()
	{
		return playersService.getData();
	}
	
	@GET
	@Path("/{playerEmail}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Player getPlayerById(@PathParam("playerEmail") String playerEmail)
	{
		return playersService.getDataByEmail(playerEmail);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Player postPlayer(Player player)
	{
		NormalUser normalUser = new NormalUser();
		player.setNormalUser(normalUser);
		normalUser.setPlayer(player);
		
		return playersService.addData(player);
	}
	
	@PUT
	@Path("/{playerId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Player updatePlayerById(@PathParam("playerId") long playerId, Player newPlayer)
	{
		Player player = playersService.getData(playerId);
		player.setItems(newPlayer.getItems());
		player.setScore(newPlayer.getScore());
		
		return playersService.updateData(player);
	}
}
