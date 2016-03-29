package org.trafficmadness.www.injection;

import org.trafficmadness.www.services.AdministratorsService;
import org.trafficmadness.www.services.AuthenticationService;
import org.trafficmadness.www.services.EntityManagerService;
import org.trafficmadness.www.services.FeedbacksService;
import org.trafficmadness.www.services.NewsService;
import org.trafficmadness.www.services.NormalUserService;
import org.trafficmadness.www.services.PlayersService;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class TrafficMadnessServletListener extends GuiceServletContextListener
{
	public static Injector injector;

	@Override
	protected Injector getInjector() 
	{
		if (injector == null) 
		{
			injector = Guice.createInjector(new ServletModule() 
			{
				@Override
				protected void configureServlets() 
				{
					bind(EntityManagerService.class);
					bind(AuthenticationService.class);
					bind(PlayersService.class);
					bind(AdministratorsService.class);
					bind(NormalUserService.class);
					bind(NewsService.class);
					bind(FeedbacksService.class);
				}
			});
		}

		return injector;
	}
}
