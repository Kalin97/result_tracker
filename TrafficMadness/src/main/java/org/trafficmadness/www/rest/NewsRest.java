package org.trafficmadness.www.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.secnod.shiro.jaxrs.Auth;
import org.trafficmadness.www.entities.News;
import org.trafficmadness.www.services.AuthenticationService;
import org.trafficmadness.www.services.NewsService;

@Path("/news")
public class NewsRest 
{
	private final AuthenticationService authenticationService;
	private final NewsService newsService;
	
	@Inject
	public NewsRest(NewsService newsService, AuthenticationService authenticationService)
	{
		this.newsService = newsService;
		this.authenticationService = authenticationService;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<News> getNews()
	{
		return newsService.getData();
	}
	
	@GET
	@Path("/{newsId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public News getNewsById(@PathParam("newsId") long newsId)
	{
		return newsService.getData(newsId);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@RequiresAuthentication
	public News createNews(@Auth Subject subject, News news)
	{
		news.setAdministrator(authenticationService.getCurrentlyLoggedInMember(subject));
		
		return newsService.addData(news);
	}
	
	@PUT
	@Path("/{newsId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@RequiresAuthentication
	public News updateNewsById(@PathParam("newsId") long newsId, News newNews)
	{
		News news = newsService.getData(newsId);

		news.setContent(newNews.getContent());
		news.setTitle(newNews.getTitle());
		
		return newsService.updateData(news);
	}
	
	@DELETE
	@Path("/{newsId}")
	@RequiresAuthentication
	public void deleteTask(@PathParam("newsId") long newsId) {
		newsService.deleteData(newsId);
	}
}
