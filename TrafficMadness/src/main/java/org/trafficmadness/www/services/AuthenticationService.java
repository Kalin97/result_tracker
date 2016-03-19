package org.trafficmadness.www.services;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.trafficmadness.www.entities.NormalUser;
import org.trafficmadness.www.interfaces.IUser;

@Singleton
public class AuthenticationService 
{
	private IUser user;
	
	@Inject
	public AuthenticationService()
	{
		user = new NormalUser();
	}
		
	public IUser getUser()
	{
		return user;
	}
}
