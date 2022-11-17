package com.bos.employee.management.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id")
	private long userId;
	@Column(name = "role")
	private String role ="USER";
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	@Embedded
	private Address address;
	@Column(name = "password")
	private String password;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "department")
	private String department;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String role, String firstname, String lastname, Address address, String password, Date dateOfBirth,
			String emailId, String mobileNo, String department) {
		super();
		this.role = role;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.department = department;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	

	
	
	
}
