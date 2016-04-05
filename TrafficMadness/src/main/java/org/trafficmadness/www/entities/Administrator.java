package org.trafficmadness.www.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.trafficmadness.www.interfaces.IUser;
import org.trafficmadness.www.types.AdministratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

@XmlRootElement
@Entity
@Table(name="Administrator")
@NamedQueries({
	@NamedQuery(name=Administrator.QUERY_ALL,
		query = "SELECT a FROM Administrator a"),
	@NamedQuery(name=Administrator.QUERY_BY_EMAIL,
		query = "SELECT a FROM Administrator a WHERE a.email=:email")
})
public class Administrator implements IUser
{
	public static final String QUERY_ALL = "administratorsAll";
	public static final String QUERY_BY_EMAIL = "queryByEmail";

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADMINISTRATOR_ID", nullable = false)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AdministratorType administratorType;
	
	@OneToMany(mappedBy = "administrator", targetEntity = News.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<News> news;
	
	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	@XmlTransient
	@JsonIgnore
	public String getPassword()
	{
		return password;
	}

	@XmlElement
	@JsonInclude
	@JsonSetter
	public void setPassword(String password)
	{
		this.password = password;
	}

	public AdministratorType getAdministratorType() 
	{
		return administratorType;
	}
	
	public void setAdministratorType(AdministratorType administratorType) 
	{
		this.administratorType = administratorType;
	}

	@XmlTransient
	@JsonIgnore
	public List<News> getNews() 
	{
		return news;
	}

	public void setNews(List<News> news) 
	{
		this.news = news;
	}
	
	@XmlTransient
	@JsonIgnore
	@Override
	public boolean isAdministrator() 
	{
		return true;
	}
}
