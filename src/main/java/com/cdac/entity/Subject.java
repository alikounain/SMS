package com.cdac.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject_details")
public class Subject {
	
	@Id
	@Column(name = "subject_id")
	private int subject_id;
	@Column(name = "subject_name")
	private String subject_name;
	@Column(name = "subject_code")
	private String subject_code;
	
	@ManyToOne
	private Class class_id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "result_id") 
	 private List<Result> result = new ArrayList<>();
	 
	public Subject() {
		super();
	}
	
	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}
	
	public Class getClass_id() {
		return class_id;
	}


	public void setClass_id(Class class_id) {
		this.class_id = class_id;
	}

	
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSubject_code() {
		return subject_code;
	}
	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}	
	
}
