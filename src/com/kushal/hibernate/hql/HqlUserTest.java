package com.kushal.hibernate.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HqlUserTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Creating the users!!
//		for(int i=1; i<=10; i++)
//		{
//			HqlUser hqlUser = new HqlUser();
//			hqlUser.setUserName("User " + i);
//			session.save(hqlUser);
//		}
		
		String minUserId = "5";
		String userName = "User 10";
		//Query query = session.createQuery("from HqlUser where userID > " +minUserId ); //No 'select *' and the query uses the class name instead of the table name!! Also concat is prone to SQL injection!!
		Query query = session.createQuery("from UserDetails where userID > :UserID and userName = :userName"); //Using named placeholders to overcome SQL injection!!
		query.setInteger("UserID", Integer.parseInt(minUserId));
		query.setString("userName", userName);
		
		query.setFirstResult(5); //The returned list starts from the 5th entry!!
		query.setMaxResults(3); //Displays a max of 3 entries in a query!!
		
		List<HqlUser> userList = (List<HqlUser>) query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of the user list is: " + userList.size());
	}
}
