package com.cdac.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.entity.Student;
import com.cdac.service.StudentService;

@Controller
//@RequestMapping("/admin/register_S")
public class StudentController {
	
	@Autowired
    private StudentService service;
	
	@GetMapping("/admin/register_S")
	private String showRegistrationForrm(Model model) {
		System.out.println("inside register student");
		model.addAttribute("details",new Student());
		return "register_student";
	}
	
	@PostMapping("/admin/register_student")
	public String processRegistration(@ModelAttribute("details") Student student) {
		
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//String encodeString = encoder.encode(admin.getPassword());
		//admin.setPassword(encodeString);
		service.save(student);
		//service1.save(details);
		return "admin_portal";
	}
	
	@GetMapping("/admin/viewstudent")
	public String viewHomePage(Model model, @Param("name") String name) {
	    List<Student> listStudent = service.listAll(name);
	    model.addAttribute("listStudent", listStudent);
	     
	    return "ViewStudent";
	}
	
	@RequestMapping("/admin/delete/{Id}")
	public String deleteProduct(@PathVariable(name = "Id") int id) {
	    service.delete(id);
	    return "admin_portal";       
	}
	
	@PostMapping("/admin/save")
	public String updateStudent(@ModelAttribute("student") Student student) {
	    service.save(student);
	     
	    return "ViewStudent";
	}
	
	@RequestMapping("/admin/edit/{Id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "Id") int id) {
	    ModelAndView mav = new ModelAndView("EditStudent");
	    Student student = service.get(id);
	    mav.addObject("student", student);
	     
	    return mav;
	}
	@GetMapping("/studentlogin")
	public String slogin(Model model) {
		model.addAttribute("student", new Student());
		return "studentlogin";
	}
	@PostMapping("/studentlogin")
	public String slogin(@ModelAttribute("student") Student student) {
		Student authStudent=service.login(student.getEmail(),student.getPassword());
		if(Objects.nonNull(authStudent)) {
			return"redirect:/student_dashboard";
		}
		else {
			return"redirect:/studentlogin";
		}
	}

}
