package com.kushal.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	
	@Id @GeneratedValue
	private int bookID;
	private String bookName;
	
	@ManyToMany(mappedBy="bookList")
	private Collection<Student> studentList = new ArrayList<Student>();

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Collection<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Collection<Student> studentList) {
		this.studentList = studentList;
	} 
}
