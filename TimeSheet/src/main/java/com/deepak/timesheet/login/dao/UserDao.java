package com.deepak.timesheet.login.dao;

import com.deepak.timesheet.login.model.User;

public interface UserDao {
	void save(User user);

	User findById(int id);

	User findBySSO(String sso);

}
