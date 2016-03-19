package org.trafficmadness.www.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.trafficmadness.www.entities.Administrator;

public class AdministratorsService
{ 	
	private final EntityManagerService entityManagerService;

	@Inject
	public AdministratorsService(EntityManagerService entityManagerService)
	{
		this.entityManagerService = entityManagerService;
	}

	public List<Administrator> getData()
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			final TypedQuery<Administrator> query = em.createNamedQuery(Administrator.QUERY_ALL, Administrator.class);
			
			return query.getResultList();
		} 
		finally 
		{
			em.close();
		}
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
