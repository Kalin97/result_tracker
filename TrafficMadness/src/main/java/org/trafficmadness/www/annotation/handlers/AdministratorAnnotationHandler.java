package org.trafficmadness.www.annotation.handlers;

import java.lang.annotation.Annotation;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.aop.AuthorizingAnnotationHandler;
import org.trafficmadness.www.annotation.RequiresAdministrator;

public class AdministratorAnnotationHandler extends AuthorizingAnnotationHandler 
{
	private final String normalUserRealm = "jdbcSecRealm";
	
    public AdministratorAnnotationHandler() 
    {
        super(RequiresAdministrator.class);
    }

    public void assertAuthorized(Annotation a) throws AuthorizationException 
    {
        if (a instanceof RequiresAdministrator && getSubject().getPrincipals().fromRealm(normalUserRealm).size() > 0) 
        {
            throw new UnauthenticatedException("Not an administrator");
        }
    }
}
