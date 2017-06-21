package com.kushal.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EmployeeDetails {

		@Id @GeneratedValue(strategy=GenerationType.AUTO)
		private int empID;
		private String empName;
		
		@OneToOne //One employee, one organization!!
		@JoinColumn(name="orgID")
		private EmployeeOrg org;
		
		@OneToMany(mappedBy="empDetails",cascade=CascadeType.PERSIST) //One employee, many projects!! //'Mapped by' creates an extra column 'empID' in the 'Employee Projects' table  
		//@JoinTable(name="EmlpoyeesProjects", joinColumns=@JoinColumn(name="EMPID"),inverseJoinColumns=@JoinColumn(name="PROJID"))
		//Cascade will ensure that all the unsaved objects of the collection will be saved automatically while saving the emp object!! 
		private Collection<EmployeeProjects> projects = new ArrayList<EmployeeProjects>();
		
		public Collection<EmployeeProjects> getProjects() {
			return projects;
		}
		public void setProjects(Collection<EmployeeProjects> projects) {
			this.projects = projects;
		}
		public EmployeeOrg getOrg() {
			return org;
		}
		public void setOrg(EmployeeOrg org) {
			this.org = org;
		}
		public int getEmpID() {
			return empID;
		}
		public void setEmpID(int empID) {
			this.empID = empID;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		
		
}
