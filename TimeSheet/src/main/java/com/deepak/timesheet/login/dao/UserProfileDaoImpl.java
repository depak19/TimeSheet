package com.deepak.timesheet.login.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.timesheet.login.model.UserProfile;

@Repository("userProfileDao")
@Transactional
public class UserProfileDaoImpl implements UserProfileDao {

	@Autowired
	SessionFactory session;

	public UserProfile findById(int id) {
		return (UserProfile) session.getCurrentSession().get(UserProfile.class,
				id);
	}

	@SuppressWarnings("unchecked")
	public List<UserProfile> findAll() {
		Criteria crit = session.getCurrentSession().createCriteria(
				UserProfile.class);
		crit.addOrder(Order.asc("type"));
		return (List<UserProfile>) crit.list();
	}

}
