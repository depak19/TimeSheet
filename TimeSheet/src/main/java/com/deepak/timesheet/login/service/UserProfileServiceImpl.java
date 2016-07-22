package com.deepak.timesheet.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.timesheet.login.dao.UserProfileDao;
import com.deepak.timesheet.login.model.UserProfile;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileDao userProfileDao;

	public UserProfile findById(int id) {
		return userProfileDao.findById(id);
	}

	public List<UserProfile> findAll() {
		return userProfileDao.findAll();
	}
}
