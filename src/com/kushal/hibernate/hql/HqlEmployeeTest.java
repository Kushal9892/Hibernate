package com.kushal.hibernate.hql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class HqlEmployeeTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		//Creating the users!!
//		for(int i=1; i<=10; i++)
//		{
//			HqlEmployee hqlEmployee = new HqlEmployee();
//			hqlEmployee.setEmployeeName("Person " + i);
//			session.save(hqlEmployee);
//		}
		
		// It is like a where clause where we specify the condition!!
		Criteria criteria = session.createCriteria(HqlEmployee.class); //Pass the entity class name!!
		criteria.add(Restrictions.eq("employeeName", "User 10")); //Adding the restriction 'where' userName = User 10!!
		criteria.add(Restrictions.gt("employeeID", 25)); //Adding the restriction where employeeID > 25!!
		criteria.add(Restrictions.between("employeeID", 22, 25));
		//criteria.add(Restrictions.or(Restrictions.between("employeeID", 20, 23), Restrictions.between("employeeID", 25, 27)));
		
		List<HqlEmployee> empList = (List<HqlEmployee>) criteria.list();	
		session.getTransaction().commit();
		session.close();
		
		for(HqlEmployee emp : empList) 
			System.out.println(emp.getEmployeeName());
	}
}
