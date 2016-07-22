package com.deepak.timesheet.login.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.timesheet.login.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	public User findById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public User findBySSO(String sso) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		crit.add(Restrictions.eq("ssoId", sso));
		return (User) crit.uniqueResult();
	}

}
