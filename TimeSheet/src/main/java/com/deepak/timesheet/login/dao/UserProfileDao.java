package com.deepak.timesheet.login.dao;

import java.util.List;

import com.deepak.timesheet.login.model.UserProfile;

public interface UserProfileDao {

	List<UserProfile> findAll();

	UserProfile findById(int id);
}
