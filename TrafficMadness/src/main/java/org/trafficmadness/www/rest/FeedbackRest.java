package org.trafficmadness.www.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.trafficmadness.www.services.FeedbacksService;
import org.trafficmadness.www.user.entities.Feedback;

@Path("/feedback")
public class FeedbackRest 
{
	private final FeedbacksService feedbackService;
	
	@Inject
	public FeedbackRest(FeedbacksService feedbackService)
	{
		this.feedbackService = feedbackService;
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Feedback postPlayerInfoByEmail(Feedback feedback)
	{
		return feedbackService.addData(feedback);
	}
	
	@PUT
	@Path("/{feedbackId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Feedback updatePlayerInfoByEmail(@PathParam("feedbackId") long feedbackId, Feedback newFeedback)
	{
		Feedback feedback = feedbackService.getData(feedbackId);
		
		feedback.setContent(newFeedback.getContent());
		feedback.setFeedbackStatus(newFeedback.getFeedbackStatus());
		feedback.setFeedbackType(newFeedback.getFeedbackType());
		
		return feedbackService.updateData(feedback);
	}
}
