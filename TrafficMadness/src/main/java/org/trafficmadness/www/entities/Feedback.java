package org.trafficmadness.www.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.trafficmadness.www.types.FeedbackStatus;
import org.trafficmadness.www.types.FeedbackType;

@XmlRootElement
@Entity
@Table(name="Feedback")
@NamedQueries({
	@NamedQuery(name=Feedback.QUERY_ALL,
		query = "SELECT f FROM Feedback f")
})
public class Feedback 
{
	public static final String QUERY_ALL = "feedbacksAll";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FEEDBACK_ID", nullable = false)
	private long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "NORMALUSER_ID", referencedColumnName = "NORMALUSER_ID")
	private NormalUser normalUser;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private FeedbackType feedbackType;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private FeedbackStatus feedbackStatus;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;

	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public FeedbackType getFeedbackType() 
	{
		return feedbackType;
	}

	public void setFeedbackType(FeedbackType feedbackType)
	{
		this.feedbackType = feedbackType;
	}

	public FeedbackStatus getFeedbackStatus() 
	{
		return feedbackStatus;
	}

	public void setFeedbackStatus(FeedbackStatus feedbackStatus) 
	{
		this.feedbackStatus = feedbackStatus;
	}

	public String getContent() 
	{
		return content;
	}

	public void setContent(String content) 
	{
		this.content = content;
	}

	public NormalUser getNormalUser() 
	{
		return normalUser;
	}

	public void setNormalUser(NormalUser normalUser) 
	{
		this.normalUser = normalUser;
	}

}
