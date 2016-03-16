package org.trafficmadness.www.services;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.trafficmadness.www.user.entities.Feedback;

public class FeedbacksService
{
	private final EntityManagerService entityManagerService;

	@Inject
	public FeedbacksService(EntityManagerService entityManagerService) 
	{
		this.entityManagerService = entityManagerService;
	}
	
	public Feedback getData(long id)
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			final Feedback result = em.find(Feedback.class, id);
			if (result == null) 
			{
				throw new IllegalArgumentException("No feedback with id: " + id);
			}
			
			return result;
		} 
		finally 
		{
			em.close();
		}
	}

	public Feedback addData(Feedback feedback)
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			em.getTransaction().begin();
			em.persist(feedback);
			em.getTransaction().commit();
			
			return feedback;
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
	
	public Feedback updateData(Feedback feedback)
	{				
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			em.getTransaction().begin();
			em.merge(feedback);
			em.getTransaction().commit();
			
			return feedback;
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
