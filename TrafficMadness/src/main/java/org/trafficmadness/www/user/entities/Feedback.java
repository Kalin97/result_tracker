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

import org.trafficmadness.www.user.types.FeedbackStatus;
import org.trafficmadness.www.user.types.FeedbackType;

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
	
	@Column(nullable = false)
	private String senderEmail;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private FeedbackType feedbackType;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private FeedbackStatus feedbackStatus;

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

	public String getSenderEmail() 
	{
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) 
	{
		this.senderEmail = senderEmail;
	}
}
