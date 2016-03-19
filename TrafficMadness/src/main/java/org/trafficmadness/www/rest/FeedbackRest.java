package org.trafficmadness.www.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.trafficmadness.www.entities.Feedback;
import org.trafficmadness.www.services.FeedbacksService;

@Path("/feedback")
public class FeedbackRest 
{
	private final FeedbacksService feedbackService;
	
	@Inject
	public FeedbackRest(FeedbacksService feedbackService)
	{
		this.feedbackService = feedbackService;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Feedback> getFeedbacks()
	{
		return feedbackService.getData();
	}
	
	@GET
	@Path("/{feedbackId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Feedback getFeedbackById(@PathParam("feedbackId") long feedbackId)
	{
		return feedbackService.getData(feedbackId);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Feedback postFeedback(Feedback feedback)
	{
		return feedbackService.addData(feedback);
	}
	
	@PUT
	@Path("/{feedbackId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Feedback updateFeedbackById(@PathParam("feedbackId") long feedbackId, Feedback newFeedback)
	{
		Feedback feedback = feedbackService.getData(feedbackId);
		
		feedback.setContent(newFeedback.getContent());
		feedback.setFeedbackStatus(newFeedback.getFeedbackStatus());
		feedback.setFeedbackType(newFeedback.getFeedbackType());
		
		return feedbackService.updateData(feedback);
	}
}
