package org.trafficmadness.www.user.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.trafficmadness.www.user.types.AdministratorType;

@XmlRootElement
@Entity
@Table(name="Administrator")
@NamedQueries({
	@NamedQuery(name=Administrator.QUERY_ALL,
		query = "SELECT a from Administrator a")
})
public class Administrator 
{
	public static final String QUERY_ALL = "administratorsAll";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADMINISTRATOR_ID", nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AdministratorType administratorType;
	
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

	public String getPassword() 
	{
		return password;
	}

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

}
