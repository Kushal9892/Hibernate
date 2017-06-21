package com.kushal.hibernate.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //Not mandatory. Least normalized as it contains more columns with null values. Hibernate by default implements the 'Single Table Strategy'!! 
//@DiscriminatorColumn(name="test", discriminatorType=DiscriminatorType.STRING) //Used only with 'Single Table' class strategy!!
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) //Creates different tables for each of the sub-classes. The sub-class table contains the columns of the member variables and annotations of the super-class!! 
@Inheritance(strategy=InheritanceType.JOINED) //Most normalized form. Keeps the data of the parent class in itself and the sub-classes do not contain any parent class info!!
public class Parent {
	@Id @GeneratedValue
	private int parentID;
	private String parentName;
	
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
