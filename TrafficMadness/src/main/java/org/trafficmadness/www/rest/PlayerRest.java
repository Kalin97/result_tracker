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

import org.trafficmadness.www.database.Database;
import org.trafficmadness.www.user.entities.PlayerInfo;

@Path("/playerRest")
public class PlayerRest 
{
	private final Database database;
	
	@Inject
	public PlayerRest(Database database)
	{
		this.database = database;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<PlayerInfo> getPlayerInfo()
	{
		return database.getData();
	}
	
	@GET
	@Path("/{playerEmail}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PlayerInfo getPlayerInfoByEmail(@PathParam("playerEmail") String playerEmail)
	{
		return database.getDataByEmail(playerEmail);
	}
	
	@POST
	@Path("/{playerEmail}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void postPlayerInfoByEmail(@PathParam("playerEmail") String playerEmail, PlayerInfo playerInfo)
	{
		database.addData(playerInfo);
	}
	
	@PUT
	@Path("/{playerEmail}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void updatePlayerInfoByEmail(@PathParam("playerEmail") String playerEmail, PlayerInfo playerInfo)
	{
		database.updateData(playerInfo);
	}
}
