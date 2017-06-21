package com.kushal.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int studentID;
	private String studentName;
	
	@ManyToMany
	private Collection<Book> bookList = new ArrayList<Book>();
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public Collection<Book> getBookList() {
		return bookList;
	}
	public void setBookList(Collection<Book> bookList) {
		this.bookList = bookList;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
}
