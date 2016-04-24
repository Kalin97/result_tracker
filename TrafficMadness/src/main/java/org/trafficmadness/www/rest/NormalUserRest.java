package org.trafficmadness.www.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.trafficmadness.www.entities.NormalUser;
import org.trafficmadness.www.services.NormalUserService;
import org.trafficmadness.www.services.PlayersService;

@Path("/users")
public class NormalUserRest 
{
	private final NormalUserService normalUsersService;
	private final PlayersService playersService;
	
	@Inject
	public NormalUserRest(NormalUserService normalUsersService, PlayersService playersService)
	{
		this.normalUsersService = normalUsersService;
		this.playersService = playersService;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<NormalUser> getUsers()
	{
		return normalUsersService.getData();
	}
	
	@GET
	@Path("/{normalUserId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public NormalUser getNormalUserById(@PathParam("normalUserId") long normalUserId)
	{
		return normalUsersService.getData(normalUserId);
	}
	
	@GET
	@Path("/email/{playerEmail}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public NormalUser getNormalUserByPlayerEmail(@PathParam("playerEmail") String playerEmail)
	{
		return playersService.getDataByEmail(playerEmail).getNormalUser();
	}
	
	@PUT
	@Path("/{normalUserId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@RequiresRoles("HEAD")
	public NormalUser updateNormalUserById(@PathParam("normalUserId") long normalUserId, NormalUser newNormalUser)
	{
		NormalUser normalUser = normalUsersService.getData(normalUserId);
		
		normalUser.setPlayer(newNormalUser.getPlayer());
		normalUser.setFriends(newNormalUser.getFriends());
		
		return normalUsersService.updateData(normalUser);
	}
	
	@DELETE
	@Path("/{userId}")
	@RequiresRoles("HEAD")
	public void deleteTask(@PathParam("userId") long userId) {
		normalUsersService.deleteData(userId);
	}
}
