package com.deepak.timesheet.login.service;

import java.util.List;

import com.deepak.timesheet.login.model.UserProfile;

public interface UserProfileService {

	UserProfile findById(int id);

	List<UserProfile> findAll();

}
