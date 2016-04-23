package org.trafficmadness.www.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.trafficmadness.www.entities.Player;


@XmlRootElement
@Entity
@Table(name="NormalUser")
@NamedQueries({
	@NamedQuery(name=NormalUser.QUERY_ALL,
		query = "SELECT u FROM NormalUser u"),
	@NamedQuery(name=NormalUser.NORMAL_USER_BY_PLAYER_NAME,
		query = "SELECT u FROM NormalUser u JOIN u.player p WHERE p.name=:name")
})
public class NormalUser
{
	public static final String QUERY_ALL = "NormalUsersAll";
	public static final String NORMAL_USER_BY_PLAYER_NAME = "NormalUserPlayerName";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NORMALUSER_ID", nullable = false)
	private long id;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name="PLAYER_ID", unique=true, nullable=false, updatable=false)
	private Player player;
	
	@JoinTable(
		joinColumns = {	@JoinColumn(name = "user", referencedColumnName = "NORMALUSER_ID", nullable = false) }, 
		inverseJoinColumns = {	@JoinColumn(name = "friend", referencedColumnName = "NORMALUSER_ID", nullable = false) }
	)
	@ManyToMany
	private List<NormalUser> friends;

	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public Player getPlayer() 
	{
		return player;
	}

	public void setPlayer(Player player) 
	{
		this.player = player;
	}

	public List<NormalUser> getFriends() 
	{
		return friends;
	}

	public void setFriends(List<NormalUser> friends) 
	{
		this.friends = friends;
	}
}
