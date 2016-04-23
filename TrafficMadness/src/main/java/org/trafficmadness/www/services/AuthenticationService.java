package org.trafficmadness.www.services;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.trafficmadness.www.entities.Administrator;
import org.trafficmadness.www.entities.NormalUser;

import com.google.inject.Provider;

@Singleton
public class AuthenticationService 
{
	private Provider<AdministratorsService> administratorService;
	private Provider<NormalUserService> normalUserService;
	
	@Inject
	public AuthenticationService(Provider<AdministratorsService> administratorService,
			Provider<NormalUserService> normalUserService)
	{
		this.administratorService = administratorService;
		this.normalUserService = normalUserService;
	}
	
	public Administrator getCurrentlyLoggedInMember(Subject subject) 
	{
		final String email = (String) subject.getPrincipal();
		if(email == null)
		{
			return null;
		}
		
		return administratorService.get().getAdministratorByEmail(email);
	}
	
	public NormalUser getCurrentlyLoggedInUser(Subject subject) 
	{
		final String name = (String) subject.getPrincipal();
		if(name == null)
		{
			return null;
		}
		
		return normalUserService.get().getNormalUserByName(name);
	}

	public String encryptPassword(String password) 
	{
		final PasswordService passwordService = getPasswordService();
		return passwordService.encryptPassword(password);
	}

	private PasswordService getPasswordService() 
	{
		final RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		final Collection<Realm> realms = securityManager.getRealms();
		PasswordMatcher credentialsMatcher = null;
		for (Realm next : realms) 
		{
			if (next instanceof AuthenticatingRealm) 
			{
				final AuthenticatingRealm authenticatingRealm = (AuthenticatingRealm) next;
				if (authenticatingRealm.getCredentialsMatcher() instanceof PasswordMatcher) {
					credentialsMatcher = (PasswordMatcher) authenticatingRealm.getCredentialsMatcher();
					break;
				}
			}
		}
		if (credentialsMatcher == null) 
		{
			throw new IllegalStateException("Bad configuration");
		}
		return credentialsMatcher.getPasswordService();
	}
	
	public void login(Subject subject, String email, String password) 
	{
		final UsernamePasswordToken token = new UsernamePasswordToken(email, password);
		subject.login(token);
	}

	public void logout(Subject subject) 
	{
		subject.logout();
	}
}
