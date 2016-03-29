package org.trafficmadness.www.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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
	private Administrator administrator;
	
	@Lob
	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;
	
	@Column(nullable = false)
	private String image;
	
	public String getImage() 
	{
		return image;
	}

	public void setImage(String image) 
	{
		this.image = image;
	}

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