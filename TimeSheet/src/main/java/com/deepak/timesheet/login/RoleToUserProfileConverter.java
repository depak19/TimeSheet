package com.deepak.timesheet.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.deepak.timesheet.login.model.UserProfile;
import com.deepak.timesheet.login.service.UserProfileService;

@Component
public class RoleToUserProfileConverter implements
		Converter<Object, UserProfile> {

	@Autowired
	UserProfileService userProfileService;

	/*
	 * Gets UserProfile by Id
	 * 
	 * @see
	 * org.springframework.core.convert.converter.Converter#convert(java.lang
	 * .Object)
	 */
	public UserProfile convert(Object element) {
		Integer id = Integer.parseInt((String) element);
		UserProfile profile = (UserProfile) userProfileService.findById(id);
		return profile;
	}

}