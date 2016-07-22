package com.deepak.timesheet.login.service;

import com.deepak.timesheet.login.model.User;

public interface UserService {

	void save(User user);

	User findById(int id);

	User findBySso(String sso);

}