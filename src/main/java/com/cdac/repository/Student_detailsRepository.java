package com.cdac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entity.Student;

public interface Student_detailsRepository extends JpaRepository<Student, Integer> {

	//@Query("select i from Student_details i where i.fName=?1")
	//Admin findByfName(String fname);
	
	@Query("select n from Student n where n.fName LIKE %?1%")
	public List<Student> findAll(String name);

	public Student findByEmailAndPassword(String email, String password);
}
