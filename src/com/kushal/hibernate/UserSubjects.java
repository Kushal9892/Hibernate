package com.kushal.hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class UserSubjects {
	private String subjectName;
	private String subjectProficiency;
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectProficiency() {
		return subjectProficiency;
	}
	public void setSubjectProficiency(String subjectProficiency) {
		this.subjectProficiency = subjectProficiency;
	}
	
	
}
