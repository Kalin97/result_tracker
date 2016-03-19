package org.trafficmadness.www.services;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Singleton
public class EntityManagerService 
{
	private final EntityManagerFactory emf;
	
	@Inject
	public EntityManagerService() 
	{
		emf = Persistence.createEntityManagerFactory("lateforschool-jpa");
	}
	
	public EntityManager createEntityManager() 
	{
		return emf.createEntityManager();
	}

}