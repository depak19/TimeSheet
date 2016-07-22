package com.deepak.timesheet.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.timesheet.model.Project;
import com.deepak.timesheet.model.Task;

@Repository("timeSheetDAO")
@Transactional
public class TimeSheetDAOImpl {
	static final Logger logger = Logger.getLogger(TimeSheetDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	public List<Project> findBySSOID(String ssoId ) {
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT P.* FROM PROJECT_DETAILS P INNER JOIN EMPLOYEE_PROJECT_MAP EP ON EP.N_PID=P.N_PID WHERE EP.V_SSO_ID=:SSO_ID ORDER BY P.V_PROJECT_NAME");
		query.setParameter("SSO_ID", ssoId);
		query.addEntity(Project.class);
		@SuppressWarnings("unchecked")
		List<Project> projectList =  query.list();
		return projectList;
	}
	
	public List<Task> findByPID(String ssoId ,int pid) {
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT T.*,TS.V_SSO_ID,TS.D_WEEK_START_DATE,TS.D_WEEK_END_DATE,TS.N_SUN_DAY,TS.N_MON_DAY,TS.N_TUE_DAY,TS.N_WED_DAY,TS.N_THU_DAY,TS.N_FRI_DAY,TS.N_SAT_DAY FROM TASK_DETAILS T LEFT OUTER JOIN TIME_SHEET TS ON T.N_PID=TS.N_PID AND T.N_TK_ID=TS.N_TK_ID AND TS.V_SSO_ID=:SSO_ID WHERE T.N_PID=:P_ID");
		query.setParameter("P_ID", pid);
		query.setParameter("SSO_ID", ssoId);
		query.addEntity(Task.class);
		@SuppressWarnings("unchecked")
		List<Task> taskList =  query.list();
		return taskList;
	}
}
