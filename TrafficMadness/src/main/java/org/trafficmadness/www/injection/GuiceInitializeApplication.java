package org.trafficmadness.www.injection;

import javax.inject.Inject;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

public class GuiceInitializeApplication extends ResourceConfig 
{
	public GuiceInitializeApplication() 
	{
	}

	@Inject
	public GuiceInitializeApplication(ServiceLocator serviceLocator) 
	{
		this();

		GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
		final GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
		guiceBridge.bridgeGuiceInjector(PlayerRestServletListener.injector);
	}
}
