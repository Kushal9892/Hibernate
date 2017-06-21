package com.kushal.hibernate.hql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="HqlPerson.byID", query="from HqlPerson where peronID > 20") //Contains the HQL query with Class name and varibale names!!
@NamedNativeQuery(name="HqlPerson.byName", query="select * from HqlPerson where personName = ?") //Contains the SQL query with the table name and column names!! 
public class HqlPerson {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int personID;
	private String personName;
	
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
}
