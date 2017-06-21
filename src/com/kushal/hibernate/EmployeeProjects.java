package com.kushal.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EmployeeProjects {
		
		@Id @GeneratedValue
		private int projID;
		private String projName;
		@ManyToOne //Many projects, one employee!!
		private EmployeeDetails empDetails;
		
		public EmployeeDetails getEmpDetails() {
			return empDetails;
		}
		public void setEmpDetails(EmployeeDetails empDetails) {
			this.empDetails = empDetails;
		}
		public int getProjID() {
			return projID;
		}
		public void setProjID(int projID) {
			this.projID = projID;
		}
		public String getProjName() {
			return projName;
		}
		public void setProjName(String projName) {
			this.projName = projName;
		}
}
