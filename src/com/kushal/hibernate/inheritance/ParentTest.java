package com.kushal.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ParentTest {

	public static void main(String[] args) {
		Parent dad = new Parent();
		dad.setParentName("Ashwin");
		
		Son boy = new Son();
		boy.setParentName("Ashwin");
		boy.setSonName("Kinnar");
		
		Daughter girl = new Daughter();
		girl.setParentName("Ashwin");
		girl.setDaughterName("Supriya");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(dad);
		session.save(boy);
		session.save(girl);
		session.getTransaction().commit();
		session.close();
	}

}
