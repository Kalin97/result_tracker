package org.trafficmadness.www.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.trafficmadness.www.entities.Item;
import org.trafficmadness.www.entities.Player;

public class PlayersService
{
	private final EntityManagerService entityManagerService;
	
	@Inject
	public PlayersService(EntityManagerService entityManagerService) 
	{
		this.entityManagerService = entityManagerService;
	}

	public List<Player> getData()
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			final TypedQuery<Player> query = em.createNamedQuery(Player.QUERY_ALL, Player.class);
			
			return query.getResultList();
		} 
		finally 
		{
			em.close();
		}
	}
	
	public Player getData(long id)
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			final Player result = em.find(Player.class, id);
			if (result == null) 
			{
				throw new IllegalArgumentException("No player with id: " + id);
			}
			
			return result;
		} 
		finally 
		{
			em.close();
		}
	}
	
	public Player getDataByEmail(String email)
	{
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			final TypedQuery<Player> query = em.createNamedQuery(Player.BY_EMAIL, Player.class);
			
			query.setParameter("email", email);
			final List<Player> result = query.setMaxResults(1).getResultList();
			
			// TODO: more meaningful error handle
			if (result.isEmpty()) 
			{
				return new Player();
			}
			
			return result.get(0);
		} 
		finally 
		{
			em.close();
		}
	}
	
	public Player addData(Player player)
	{
		for(Item item : player.getItems())
		{
			item.setPlayer(player);
		}

		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			em.getTransaction().begin();
			em.persist(player);
			em.getTransaction().commit();
			
			return player;
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
	
	public Player updateData(Player player)
	{				
		for(Item item : player.getItems())
		{
			item.setPlayer(player);
		}
		
		final EntityManager em = entityManagerService.createEntityManager();
		try 
		{
			em.getTransaction().begin();
			em.merge(player);
			em.getTransaction().commit();
			
			return player;
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
