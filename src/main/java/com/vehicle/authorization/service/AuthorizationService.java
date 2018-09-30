package com.vehicle.authorization.service;

import com.vehicle.authorization.bean.AuthorizationBean;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthorizationService {
	
	private AuthorizationBean bean;

	public boolean isAuthorized() {
		return bean.getUserName().equalsIgnoreCase("mathivanan") && bean.getPassword().equalsIgnoreCase("passwordm");
	}

}
