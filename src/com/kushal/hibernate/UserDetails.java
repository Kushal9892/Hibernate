package com.kushal.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity //Denotes that this is a model entity class
public class UserDetails {
	
	@Id //Denotes that this is a Primary Key!!
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int userID;
	
	@Column (name="new_userName") //Renames the column in the DB to the new name provided!!
	private String userName;
	private String userEmail;
	
	// @Temporal (TemporalType.DATE) //Will persist only the DATE in the DB!!
	// @Temporal (TemporalType.TIME) //Will persist only the TIME in the DB!!
	@Temporal (TemporalType.TIMESTAMP) //Will persist the DATE along with the TIME in the DB!!
	private Date userJoinDate;
	
	@Transient //Will ignore this String!!
	private String userMobile;
	
	@Embedded //This will ensure that this field is embedded to other object "UserDetails" 
	@AttributeOverrides({
	@AttributeOverride (name="street",column=@Column(name="homeStreet")),
	@AttributeOverride (name="city",column=@Column(name="homeCity")),
	@AttributeOverride (name="state",column=@Column(name="homeState")),
	@AttributeOverride (name="pincode",column=@Column(name="homePincode"))})
	private UserAddress homeAddress;
	
	@Embedded //This will ensure that this field is embedded to other object "UserDetails" 
	@AttributeOverrides({
	@AttributeOverride (name="street",column=@Column(name="offcStreet")),
	@AttributeOverride (name="city",column=@Column(name="offcCity")),
	@AttributeOverride (name="state",column=@Column(name="offcState")),
	@AttributeOverride (name="pincode",column=@Column(name="offcPincode"))})	
	private UserAddress officeAddress;
	
	/* @ElementCollection //When we have a collection of UserSubjects!!
	//@GenericGenerator(name = "hilo-gen", strategy = "hilo") //This will create a generator to generate the Primary key for the Collection!!
	//@CollectionId(columns = { @Column(name="subjectID")}, generator = "hilo-gen", type = @Type(type="long")) //This will give a primary key to the collection!! 
	@JoinTable (name="userSubjects", joinColumns=@JoinColumn(name="userID"))*/
	
	@ElementCollection(fetch=FetchType.EAGER) //When we have a collection of UserSubjects!!
	private Collection<UserSubjects> userKnowsSubjects = new ArrayList<UserSubjects>(); 

	public Collection<UserSubjects> getUserKnowsSubjects() {
		return userKnowsSubjects;
	}
	public void setUserKnowsSubjects(Collection<UserSubjects> userKnowsSubjects) {
		this.userKnowsSubjects = userKnowsSubjects;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Date getUserJoinDate() {
		return userJoinDate;
	}
	public void setUserJoinDate(Date userJoinDate) {
		this.userJoinDate = userJoinDate;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public UserAddress getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(UserAddress homeAddress) {
		this.homeAddress = homeAddress;
	}
	public UserAddress getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(UserAddress officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
}
