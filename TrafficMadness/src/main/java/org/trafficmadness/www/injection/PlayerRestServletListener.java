package org.trafficmadness.www.injection;

import org.trafficmadness.www.services.EntityManagerService;
import org.trafficmadness.www.services.PlayersService;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class PlayerRestServletListener extends GuiceServletContextListener
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
					bind(PlayersService.class);
				}
			});
		}

		return injector;
	}
}
