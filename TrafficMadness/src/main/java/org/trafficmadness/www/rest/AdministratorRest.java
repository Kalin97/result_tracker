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

import org.trafficmadness.www.services.AdministratorsService;
import org.trafficmadness.www.user.entities.Administrator;

@Path("/administrator")
public class AdministratorRest 
{
	private final AdministratorsService administratorsService;
	
	@Inject
	public AdministratorRest(AdministratorsService administratorsService)
	{
		this.administratorsService = administratorsService;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Administrator> getAdministrators()
	{
		return administratorsService.getData();
	}
	
	@GET
	@Path("/{administratorId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Administrator getAdministratorById(@PathParam("administratorId") long administratorId)
	{
		return administratorsService.getData(administratorId);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Administrator postAdministrator(Administrator administrator)
	{
		return administratorsService.addData(administrator);
	}
	
	@PUT
	@Path("/{administratorId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Administrator updateAdministratorById(@PathParam("administratorId") long administratorId, Administrator newAdministrator)
	{
		Administrator administrator = administratorsService.getData(administratorId);
		
		administrator.setAdministratorType(newAdministrator.getAdministratorType());
		administrator.setPassword(newAdministrator.getPassword());
		administrator.setEmail(newAdministrator.getEmail());
		
		return administratorsService.updateData(administrator);
	}
}
