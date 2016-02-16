package org.trafficmadness.www.user.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item 
{
	private String type;
	private int level;
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}
}
