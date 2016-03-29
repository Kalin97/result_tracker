package org.trafficmadness.www.rest;

import javax.ws.rs.Path;

import org.trafficmadness.www.services.AuthenticationService;

@Path("/authentication")
public class AuthenticationRest 
{
	private final AuthenticationService authenticationService;
	
	public AuthenticationRest(AuthenticationService authenticationService)
	{
		this.authenticationService = authenticationService;
	}
	
//	public NormalUser login(@Auth Subject subject, NormalUser normalUser)
//	{
//		authenticationService. 	
//	}
}
