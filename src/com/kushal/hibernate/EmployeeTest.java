package com.kushal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeTest {

	public static void main(String[] args) {
		
		EmployeeDetails emp1 = new EmployeeDetails();
		emp1.setEmpName("Kushal Majithia");
		
		EmployeeOrg org1 = new EmployeeOrg();
		org1.setOrgName("Tech Mahindra");
		
		EmployeeProjects proj1 = new EmployeeProjects();
		EmployeeProjects proj2 = new EmployeeProjects();
		proj1.setProjName("Jio");
		proj2.setProjName("TechM");
		
		emp1.setOrg(org1);
		emp1.getProjects().add(proj1);
		emp1.getProjects().add(proj2);
		proj1.setEmpDetails(emp1);
		proj2.setEmpDetails(emp1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp1);
		session.save(org1);
		session.save(proj1);
		session.save(proj2);
		session.getTransaction().commit();
		session.close();
	}

}
