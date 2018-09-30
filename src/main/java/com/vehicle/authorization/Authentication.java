package com.vehicle.authorization;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vehicle.authorization.bean.AuthorizationBean;
import com.vehicle.authorization.service.AuthorizationService;

public class Authentication  implements Filter{
	
	private static final String USERNAME="username";
	private static final String PASSWORD="password";
	private static final String NOT_AUTHORIZED = "User Not Authorized.";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		
		if(request instanceof HttpServletRequest) {
			
			if(isAuthorized((HttpServletRequest)request)) 
				filterchain.doFilter(request, response);
			else {
				HttpServletResponse httpResponse = ((HttpServletResponse) response);
				httpResponse.getWriter().print(NOT_AUTHORIZED);
				httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
		
	}

	private boolean isAuthorized(HttpServletRequest httpRequest) {
		boolean isAuthorized = false;
		
		if((httpRequest.getHeader(USERNAME)!= null) && (httpRequest.getHeader(PASSWORD)!=null)) {
			AuthorizationBean authBean = new AuthorizationBean(httpRequest.getHeader(USERNAME), httpRequest.getHeader(PASSWORD));
			AuthorizationService authService = new AuthorizationService(authBean);
			isAuthorized=authService.isAuthorized();
		}	
		return isAuthorized;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
