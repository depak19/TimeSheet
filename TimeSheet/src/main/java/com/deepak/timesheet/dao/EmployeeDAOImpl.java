package com.deepak.timesheet.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.timesheet.model.Employee;
import com.deepak.timesheet.util.StringUtils;

@Repository("employeeDAO")
@Transactional
public class EmployeeDAOImpl {
	static final Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> listEmployee(String empid, String empname,
		String salary, String phno, int offset, int noOfRecords) {
		String sbSql = getFilter(empid, empname, salary, phno, offset,noOfRecords);
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sbSql);
		query.addEntity(Employee.class);
		@SuppressWarnings("unchecked")
		List<Employee> employeeList = query.list();
		return employeeList;
	}

	protected String getFilter(String empid, String empname, String salary,
			String phno, int offset, int noOfRecords) {

		StringBuilder sbSql = new StringBuilder(
				"SELECT * FROM (SELECT E.*,ROWNUM RM FROM EMPLOYEES E WHERE 1=1 ");
		if (noOfRecords > 0)
			sbSql.append(" AND ROWNUM <=" + (offset + noOfRecords));

		if (StringUtils.notNullOrBlank(empid)) {
			sbSql.append(" AND E.EMPLOYEE_ID='" + empid + "'");
		}
		if (StringUtils.notNullOrBlank(empname)) {
			sbSql.append(" AND UPPER(E.FIRST_NAME || E.LAST_NAME) LIKE UPPER('%"
					+ empname + "%')");
		}
		if (StringUtils.notNullOrBlank(salary)) {
			sbSql.append(" AND E.SALARY LIKE '%" + salary + "%'");
		}
		if (StringUtils.notNullOrBlank(phno)) {
			sbSql.append(" AND E.PHONE_NUMBER LIKE '%" + phno + "%'");
		}
		sbSql.append(" ORDER BY E.EMPLOYEE_ID) EMPLOYEES");
		if (noOfRecords > 0)
			sbSql.append(" WHERE RM >=" + (offset + 1));
		else
			sbSql.append(" WHERE 1=1");
		return sbSql.toString();
	}
}
