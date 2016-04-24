package org.trafficmadness.www.annotation.handlers;

import java.lang.annotation.Annotation;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.aop.AuthorizingAnnotationHandler;
import org.trafficmadness.www.annotation.RequiresNormalUser;

public class NormalUserAnnotationHandler extends AuthorizingAnnotationHandler 
{
	private final String normalUserRealm = "jdbcSecRealm";
	
    public NormalUserAnnotationHandler() 
    {
        super(RequiresNormalUser.class);
    }

    public void assertAuthorized(Annotation a) throws AuthorizationException 
    {
        if (a instanceof RequiresNormalUser && getSubject().getPrincipals().fromRealm(normalUserRealm).size() == 0) 
        {
            throw new UnauthenticatedException("Not a normal user");
        }
    }
}
