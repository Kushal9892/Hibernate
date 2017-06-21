package com.kushal.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrudTest {

	public static void main(String[] args) {
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
//		//Create Users!!
//		for (int i=1; i<=10; i++) {
//			CrudUser crudUser = new CrudUser();
//			crudUser.setUserName("User " + i);
//			session.save(crudUser);
//		}
		
//		//Read the user!!
//		CrudUser crudUser=(CrudUser)session.get(CrudUser.class, 5);
//		System.out.println("The user is: " + crudUser.getUserName()); //change from 'create' to 'update' in cfg!! 
		
		//Update the user!!
		CrudUser crudUser = session.get(CrudUser.class, 6);
		crudUser.setUserName("Updated User 6");
		
//		//Delete the user!!
//		CrudUser crudUser = session.get(CrudUser.class, 4);
//		session.delete(crudUser);
		
		session.getTransaction().commit();
		session.close();

	}

}
