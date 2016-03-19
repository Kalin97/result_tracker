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

import org.trafficmadness.www.entities.News;
import org.trafficmadness.www.services.NewsService;

@Path("/news")
public class NewsRest 
{
	private final NewsService newsService;
	
	@Inject
	public NewsRest(NewsService newsService)
	{
		this.newsService = newsService;
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
	public News postNews(News news)
	{
		return newsService.addData(news);
	}
	
	@PUT
	@Path("/{newsId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public News updateNewsById(@PathParam("newsId") long newsId, News newNews)
	{
		News news = newsService.getData(newsId);

		news.setContent(newNews.getContent());
		news.setTitle(newNews.getTitle());
		
		return newsService.updateData(news);
	}
}
