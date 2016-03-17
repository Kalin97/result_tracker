package org.trafficmadness.www.user.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@XmlRootElement
@Entity
@Table(name="Item")
public class Item 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_ID", nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private int level;
	
	@Column(name = "PLAYER_ID")
	private long playerId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "PLAYER_ID", referencedColumnName = "PLAYER_ID")
	@JsonBackReference
	private Player player;

	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
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

	public Player getPlayer() 
	{
		return player;
	}
	
	public void setPlayer(Player player) 
	{
		this.player = player;
	}
}
