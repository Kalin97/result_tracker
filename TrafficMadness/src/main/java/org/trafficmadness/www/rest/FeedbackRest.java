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

import org.apache.shiro.subject.Subject;
import org.secnod.shiro.jaxrs.Auth;
import org.trafficmadness.www.annotation.RequiresAdministrator;
import org.trafficmadness.www.annotation.RequiresNormalUser;
import org.trafficmadness.www.entities.Feedback;
import org.trafficmadness.www.entities.NormalUser;
import org.trafficmadness.www.services.FeedbacksService;
import org.trafficmadness.www.services.NormalUserService;
import org.trafficmadness.www.services.PlayersService;
import org.trafficmadness.www.types.FeedbackStatus;

@Path("/feedback")
public class FeedbackRest 
{
	private final FeedbacksService feedbackService;
	private final PlayersService playersService;
	
	@Inject
	public FeedbackRest(FeedbacksService feedbackService,
			PlayersService playersService)
	{
		this.feedbackService = feedbackService;
		this.playersService = playersService;	
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@RequiresAdministrator
	public List<Feedback> getFeedbacks()
	{
		return feedbackService.getData();
	}
	
	@GET
	@Path("/{feedbackId}")
	@RequiresAdministrator
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Feedback getFeedbackById(@PathParam("feedbackId") long feedbackId)
	{
		return feedbackService.getData(feedbackId);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@RequiresNormalUser
	public Feedback postFeedback(@Auth Subject subject, Feedback feedback)
	{
		String userEmail = subject.getPrincipal().toString();
		
		NormalUser normalUser = playersService.getDataByName(userEmail).getNormalUser();
		feedback.setNormalUser(normalUser);
		
		feedback.setFeedbackStatus(FeedbackStatus.ACTIVE);
		
		return feedbackService.addData(feedback);
	}
	
	@PUT
	@Path("/{feedbackId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@RequiresAdministrator
	public Feedback updateFeedbackById(@PathParam("feedbackId") long feedbackId, Feedback newFeedback)
	{
		Feedback feedback = feedbackService.getData(feedbackId);
		
		feedback.setFeedbackStatus(newFeedback.getFeedbackStatus());
		
		return feedbackService.updateData(feedback);
	}
}
