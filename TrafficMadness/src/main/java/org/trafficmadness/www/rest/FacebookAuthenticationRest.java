package org.trafficmadness.www.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.secnod.shiro.jaxrs.Auth;
import org.trafficmadness.www.entities.NormalUser;
import org.trafficmadness.www.services.AuthenticationService;

@Path("/facebookAuthentication")
public class FacebookAuthenticationRest 
{
	private final AuthenticationService authenticationService;
	
	@Inject
	public FacebookAuthenticationRest(AuthenticationService authenticationService)
	{
		this.authenticationService = authenticationService;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@RequiresGuest
	public NormalUser login(@Auth Subject subject, String name)
	{
		authenticationService.login(subject, name, name);
		
		return authenticationService.getCurrentlyLoggedInUser(subject);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public NormalUser getCurrentlyLoggedInUser(@Auth Subject subject) 
	{
		return authenticationService.getCurrentlyLoggedInUser(subject);
	}
	
	@DELETE
	@RequiresAuthentication
	public void logout(@Auth Subject subject) 
	{
		authenticationService.logout(subject);
	}
}
