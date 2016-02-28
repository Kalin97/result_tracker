package org.trafficmadness.www.user.entities;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlayerInfo 
{
	private String name;
	private String email;
	private int score;
	private List<Item> items;
		
	public PlayerInfo()
	{
		items = new LinkedList<Item>();
	}
	
	public PlayerInfo(List<Item> items)
	{
		this.items = items;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public List<Item> getItems()
	{
		return items;
	}
	
	public void setItems(List<Item> items)
	{
		this.items = items;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
}
