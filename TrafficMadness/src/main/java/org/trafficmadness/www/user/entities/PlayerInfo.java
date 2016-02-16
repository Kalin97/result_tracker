package org.trafficmadness.www.user.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlayerInfo 
{
	private int score;
	private List<Item> items;
		
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
}
