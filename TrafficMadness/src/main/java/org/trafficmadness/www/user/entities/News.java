package org.trafficmadness.www.user.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="News")
public class News 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NEWS_ID", nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	// TODO connect user to news
	@Column(nullable = false)
	private String publisher;
	
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

	public String getPublisher() 
	{
		return publisher;
	}

	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}

	public String getContent() 
	{
		return content;
	}

	public void setContent(String content) 
	{
		this.content = content;
	}
}