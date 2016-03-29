package org.trafficmadness.www.injection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.openjpa.jdbc.schema.SimpleDriverDataSource;
import org.trafficmadness.www.services.EntityManagerService;

public class WebDataSource  extends SimpleDriverDataSource 
{
	@Override
	protected Connection getSimpleConnection(Properties props)
			throws SQLException {
		final EntityManagerService entityManagerService = TrafficMadnessServletListener.injector.getInstance(EntityManagerService.class);
		return entityManagerService.createEntityManager().unwrap(Connection.class);
	}
}
