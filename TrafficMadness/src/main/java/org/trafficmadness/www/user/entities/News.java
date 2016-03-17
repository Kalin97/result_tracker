package org.trafficmadness.www.user.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@XmlRootElement
@Entity
@Table(name="News")
@NamedQueries({
	@NamedQuery(name=News.QUERY_ALL,
		query = "SELECT n FROM News n")
})
public class News 
{
	public static final String QUERY_ALL = "newsAll";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NEWS_ID", nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ADMINISTRATOR_ID", referencedColumnName = "ADMINISTRATOR_ID")
	@JsonBackReference
	private Administrator administrator;
	
	@Column(nullable = false)
	private String content;
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getContent() 
	{
		return content;
	}

	public void setContent(String content) 
	{
		this.content = content;
	}

	public Administrator getAdministrator() 
	{
		return administrator;
	}

	public void setAdministrator(Administrator administrator) 
	{
		this.administrator = administrator;
	}
	
	
}