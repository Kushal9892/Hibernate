package com.kushal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentTest {

	public static void main(String[] args) {
		
		Student student1 = new Student();
		Student student2 = new Student();
		student1.setStudentName("Kushal Majithia");
		student2.setStudentName("Sampada Dal");
		
		Book book1 = new Book();
		Book book2 = new Book();
		book1.setBookName("Book 1");
		book2.setBookName("Book 2");
		
		student1.getBookList().add(book1);
		student1.getBookList().add(book2);
		student2.getBookList().add(book1);
		student2.getBookList().add(book2);
		book1.getStudentList().add(student1);
		book1.getStudentList().add(student2);
		book2.getStudentList().add(student1);
		book2.getStudentList().add(student2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(book1);
		session.save(book2);
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();
		session.close();
		
	}

}
