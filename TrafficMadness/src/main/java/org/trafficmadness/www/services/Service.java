package org.trafficmadness.www.services;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Service 
{
	protected final EntityManagerService entityManagerService;
	
	@Inject
	public Service(EntityManagerService entityManagerService) 
	{
		this.entityManagerService = entityManagerService;
	}
}
