package com.kushal.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserTest {

	public static void main(String[] args) {
		
		UserAddress homeAddr1 = new UserAddress();
		UserAddress homeAddr2 = new UserAddress();
		UserAddress offcAddr1 = new UserAddress();
		UserAddress offcAddr2 = new UserAddress();
		
		homeAddr1.setStreet("Jodhali Baug Road");
		homeAddr1.setCity("Thane");
		homeAddr1.setState("Maharashtra");
		homeAddr1.setPincode("400601");
		
		offcAddr1.setStreet("Saki Vihar Road");
		offcAddr1.setCity("Mumbai");
		offcAddr1.setState("Maharashtra");
		offcAddr1.setPincode("400065");
		
		homeAddr2.setStreet("Gatla Gaon Road");
		homeAddr2.setCity("Chembur");
		homeAddr2.setState("Maharashtra");
		homeAddr2.setPincode("400065");
		
		offcAddr2.setStreet("Thane Belpaur Road");
		offcAddr2.setCity("Ghansoli");
		offcAddr2.setState("Maharashtra");
		offcAddr2.setPincode("400701");
		
		UserSubjects user1subject1 = new UserSubjects();
		UserSubjects user1subject2 = new UserSubjects();
		UserSubjects user2subject1 = new UserSubjects();
		UserSubjects user2subject2 = new UserSubjects();
		
		user1subject1.setSubjectName("Java");
		user1subject1.setSubjectProficiency("4");
		user1subject2.setSubjectName("SQL");
		user1subject2.setSubjectProficiency("3");
		
		user2subject1.setSubjectName("Java");
		user2subject1.setSubjectProficiency("5");
		user2subject2.setSubjectName("SQL");
		user2subject2.setSubjectProficiency("5");		
		
		UserDetails user = new UserDetails();
		UserDetails user2 = new UserDetails();
		user.setUserID(353124);
		user.setUserName("Kushal Majithia");
		user.setUserEmail("km00353124@techmahindra.com");
		user.setUserMobile("9987581283");
		user.setUserJoinDate(new Date());
		user.setHomeAddress(homeAddr1);
		user.setOfficeAddress(offcAddr1);
		user.getUserKnowsSubjects().add(user1subject1);
		user.getUserKnowsSubjects().add(user1subject2);
		
		user2.setUserID(353201);
		user2.setUserName("Sampada Dal");
		user2.setUserEmail("sd00353201@techmahindra.com");
		user2.setUserMobile("9821520758");
		user2.setUserJoinDate(new Date());
		user2.setHomeAddress(homeAddr2);
		user2.setOfficeAddress(offcAddr2);
		user2.getUserKnowsSubjects().add(user2subject1);
		user2.getUserKnowsSubjects().add(user2subject2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		//user.getUserKnowsSubjects();
		session.close();
		System.out.println(user.getUserKnowsSubjects().size());
		System.out.println(user2.getUserKnowsSubjects().size());
		
	}
}