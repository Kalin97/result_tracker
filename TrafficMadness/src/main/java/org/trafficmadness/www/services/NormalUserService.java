package org.trafficmadness.www.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.trafficmadness.www.entities.NormalUser;

public class NormalUserService
{ 	
	private final EntityManagerService entityManagerService;

	@Inject
	public NormalUserService(EntityManagerService entityManagerService)
	{
		this.entityManagerService = entityManagerService;
	}

	public List<NormalUser> getData()
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			final TypedQuery<NormalUser> query = em.createNamedQuery(NormalUser.QUERY_ALL, NormalUser.class);
			
			return query.getResultList();
		} 
		finally 
		{
			em.close();
		}
	}
	
	public NormalUser getData(long id)
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			final NormalUser result = em.find(NormalUser.class, id);
			if (result == null) 
			{
				throw new IllegalArgumentException("No user with id: " + id);
			}
			
			return result;
		} 
		finally 
		{
			em.close();
		}
	}

	public NormalUser addData(NormalUser user)
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			
			return user;
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
	
	public NormalUser updateData(NormalUser user)
	{				
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			
			return user;
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
	
	public void deleteData(long userId) 
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			em.getTransaction().begin();
			final NormalUser user = em.find(NormalUser.class, userId);
			if (user == null) 
			{
				throw new IllegalArgumentException("No user with id: " + userId);
			}
			em.remove(user);
			
			em.getTransaction().commit();
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
