package org.trafficmadness.www.services;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.trafficmadness.www.user.entities.News;

public class NewsService
{
	private final EntityManagerService entityManagerService;

	@Inject
	public NewsService(EntityManagerService entityManagerService)
	{
		this.entityManagerService = entityManagerService;
	}

	public News getData(long id)
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			final News result = em.find(News.class, id);
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

	public News addData(News news)
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			em.getTransaction().begin();
			em.persist(news);
			em.getTransaction().commit();
			
			return news;
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
	
	public News updateData(News news)
	{				
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			em.getTransaction().begin();
			em.merge(news);
			em.getTransaction().commit();
			
			return news;
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
