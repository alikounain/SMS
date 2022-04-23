package com.cdac.entity;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;
	public void setFather(String father) {
		this.father = father;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDate_of_Submission(String date_of_Submission) {
		this.date_of_Submission = date_of_Submission;
	}

	public void setFee_status(String fee_status) {
		this.fee_status = fee_status;
	}

	@Column(name = "fName", nullable=false)
	private String fName;
	@Column(name = "lName")
	private String lName;
	@Column(name = "DOB", nullable=false)
	private String DOB;
	@Column(name = "email",nullable=false,unique=true)
	private String email;
	@Column(name = " password",nullable=false)
	private String password;
	@Column(name = "father",nullable=false)
	private String father;
	@Column(name = "mother",nullable=false)
	private String mother;
//	@Column(name = "Class_id")
//	private int class_id;
	@Column(name = "gender",nullable=false)
	private String gender;
	@Column(name = "Address",nullable=false)
	private String address;
	@Column(name = "Date_of_Submission",nullable=false)
	private String date_of_Submission;
	@Column(name = "fee_status",nullable=false)
	private String fee_status;

	//@Column(name = "S_mobile")
	//private int mobile;

	/*
	 * @OneToMany(cascade = CascadeType.ALL,mappedBy = "s_id") private List<Address>
	 * address = new ArrayList<>();
	 */
	
	 @ManyToOne
	 private Class classes;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "result_id") 
	 private List<Result> result = new ArrayList<>();
	 
	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}
	 
	public Student() {
		super();
	}
	
	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}

	public String getFee_status() {
		return fee_status;
	}
	public void setfee_status(String fee_status) {
		this.fee_status = fee_status;
	}
	public String getDate_of_Submission() {
		return date_of_Submission;
	}
	public void setdate_of_Submission(String date_of_Submission) {
		this.date_of_Submission = date_of_Submission;
	}
	
	
	

	/*
	 * public int getAddress_id() { return address_id; } public void
	 * setaddress_id(int address_id) { this.address_id = address_id; }
	 */
	
	public long getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFather() {
		return father;
	}
	public void setfather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setmother(String mother) {
		this.mother = mother;
	}
	
//	public int getClass_id() { 
//		return class_id; 
//		} 
//	public void setclass_id(int class_id) { 
//		this.class_id = class_id; 
//		}
	 
	
	public String getGender() {
	return gender;
	}
	public Class getClasses() {
		return classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	public void setgender(String gender) {
	this.gender = gender;
	}

	/*
	 * public List<Address> getAddress() { return address; }
	 * 
	 * public void setAddress(List<Address> address) { this.address = address; }
	 */
	
	
	
//	public int getmobile() {
//	return mobile;
//	}
//	public void setmobile(int mobile) {
//	this.mobile = mobile;
//	}

}
