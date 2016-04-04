package org.trafficmadness.www.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name="Player")
@NamedQueries({
	@NamedQuery(name=Player.QUERY_ALL,
		query = "SELECT p FROM Player p"),
	@NamedQuery(name=Player.BY_EMAIL,
		query = "SELECT p FROM Player p WHERE p.email=:email"),
	@NamedQuery(name=Player.SORTED_BY_SCORE,
		query = "SELECT p FROM Player p ORDER BY p.score DESC"),
})
public class Player
{
	public static final String QUERY_ALL = "playersAll";
	public static final String BY_EMAIL = "byEmail";
	public static final String SORTED_BY_SCORE = "sortedByScore";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAYER_ID", nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private int score;
	
	@OneToMany(mappedBy = "player", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Item> items;
	
	@OneToOne(mappedBy = "player", cascade = CascadeType.ALL, optional = false)
	private NormalUser normalUser;
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
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

	@JsonIgnore
	public NormalUser getNormalUser() 
	{
		return normalUser;
	}
	
	@JsonIgnore
	public void setNormalUser(NormalUser normalUser) 
	{
		this.normalUser = normalUser;
	}
}
