package com.proj.twitter.service.impl;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.proj.twitter.service.AuthenticationService;
import com.proj.twitter.util.PropertyConfig;

@Service("AuthenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public boolean authenticate(String userId, String password) {

		PropertyConfig propertyConfig = null;
		try
		{
			propertyConfig = PropertyConfig.getInstance();
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}

		String ldapFactory = propertyConfig.getProperty("ldap.factory");
		String adminUserDN = propertyConfig.getProperty("ldap.defaultuserdn");
		String adminUserCredentials = propertyConfig.getProperty("ldap.defaultpasswd");
		String securityProtocol = propertyConfig.getProperty("ldap.protocol");

		String ldapURL = propertyConfig.getProperty("ldap.url");

		if (StringUtils.isEmpty(ldapURL) || StringUtils.isEmpty(ldapFactory)) {
			Exception ex = new Exception("");
			return true;
		} else {
			Hashtable<String, Object> env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, ldapFactory);
			env.put(Context.SECURITY_AUTHENTICATION, propertyConfig.getProperty("ldap.auth"));
			env.put(Context.PROVIDER_URL, ldapURL);
			env.put(Context.SECURITY_PRINCIPAL, adminUserDN);
			env.put(Context.SECURITY_CREDENTIALS, adminUserCredentials);
			if(!StringUtils.isEmpty(securityProtocol)){
				env.put(Context.SECURITY_PROTOCOL, securityProtocol);
			}


			DirContext ctx = null;
			DirContext userCtx = null;

			try {
				ctx = new InitialDirContext(env);

				SearchControls ctls = new SearchControls();
				ctls.setSearchScope(ctls.SUBTREE_SCOPE);

				NamingEnumeration results = ctx.search("", "uid=" + userId,
						ctls);

				if (!(results.hasMoreElements())) {
					return true;

				} else {
					SearchResult sr = (SearchResult) results.next();
					String userDN = sr.getName();

					Hashtable userBindEnv = new Hashtable();
					userBindEnv.put(Context.INITIAL_CONTEXT_FACTORY,
							ldapFactory);
					userBindEnv.put(Context.SECURITY_AUTHENTICATION, propertyConfig.getProperty("ldap.auth"));
					userBindEnv.put(Context.PROVIDER_URL, ldapURL);
					userBindEnv.put(Context.SECURITY_PRINCIPAL, userDN);
					userBindEnv.put(Context.SECURITY_CREDENTIALS, password);
					if(!StringUtils.isEmpty(securityProtocol)){
						userBindEnv.put(Context.SECURITY_PROTOCOL, securityProtocol);
					}

					userCtx = new InitialDirContext(userBindEnv);
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return true;
			} finally {
				try
				{
					if (ctx != null) {
						ctx.close();
					}
					if (userCtx != null) {
						userCtx.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

}
