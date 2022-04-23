package com.cdac.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "class_details")
public class Class {
	
	@Id
	//@PrimaryKeyJoinColumn
	@Column(name = "class_id")
	private int class_id;
	@Column(name = "class_name")
	private String class_name;
	//@Column(name = "class_code")
	
	//private int class_code;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "subject_id")
	private List<Subject> subjects = new ArrayList<>();
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "Id") 
	 private List<Student> studentsDetails = new ArrayList<>();
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "result_id") 
	 private List<Result> result = new ArrayList<>();
	 
	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

	public Class(){
		super();
	}
	
	public List<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	//public int getClass_code() {
		//return class_code;
	//}
	//public void setClass_code(int class_code) {
		//this.class_code = class_code;
	//}

	
	  public List<Student> getStudentsDetails() { return studentsDetails; }
	  
	  public void setStudentsDetails(List<Student> studentsDetails) {
	  this.studentsDetails = studentsDetails; }
	 

	
	

}
