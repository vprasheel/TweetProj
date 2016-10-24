package com.proj.twitter.filter;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proj.twitter.service.AuthenticationService;
import com.proj.twitter.util.PropertyConfig;

@Component("TwitterRequestFilter")
@Provider
@PreMatching
public class TwitterRequestFilter implements ContainerRequestFilter {
	
	@Autowired
	private AuthenticationService authService;
	
	@Context
	private ServletContext servletContext;

	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		String user = requestContext.getHeaderString("AUTH_USER");
		String pass = requestContext.getHeaderString("AUTH_CREDENTIALS");
		PropertyConfig propertyConfig = PropertyConfig.getInstance(servletContext);
		
		if(!authService.authenticate(user, pass)){
			throw new NotAuthorizedException("Invalid Login Credentials");
		}
		
	}

}
