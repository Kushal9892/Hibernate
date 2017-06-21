package com.kushal.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HqlPersonTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Creating the users!!
		for(int i=1; i<=10; i++)
		{
			HqlPerson hqlPerson = new HqlPerson();
			hqlPerson.setPersonName("Person " + i);
			session.save(hqlPerson);
		}
		
		session.getTransaction().commit();
		session.close();
	}

}
