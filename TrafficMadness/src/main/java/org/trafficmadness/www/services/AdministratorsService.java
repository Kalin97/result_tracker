package org.trafficmadness.www.services;

import javax.persistence.EntityManager;

import org.trafficmadness.www.user.entities.Administrator;

public class AdministratorsService extends Service
{
	public AdministratorsService(EntityManagerService entityManagerService)
{
		super(entityManagerService);
	}

	public Administrator getData(long id)
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			final Administrator result = em.find(Administrator.class, id);
			if (result == null) 
			{
				throw new IllegalArgumentException("No news with id: " + id);
			}
			
			return result;
		} 
		finally 
		{
			em.close();
		}
	}

	public Administrator addData(Administrator administrator)
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			em.getTransaction().begin();
			em.persist(administrator);
			em.getTransaction().commit();
			
			return administrator;
		} 
		finally 
		{
			if (em.getTransaction().isActive()) 
			{
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
	
	public Administrator updateData(Administrator administrator)
	{				
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			em.getTransaction().begin();
			em.merge(administrator);
			em.getTransaction().commit();
			
			return administrator;
		} 
		finally 
		{
			if (em.getTransaction().isActive()) 
			{
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
}
