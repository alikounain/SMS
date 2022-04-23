package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdac.entity.Admin;
import com.cdac.repository.*;


@Controller
public class AppController {
	

	@Autowired
	private AdminRepository aRepository;
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/register")
	private String showSignUp(Model model) {
		model.addAttribute("admin",new Admin());
		return "signup_form";
	}
	@PostMapping("/process_register")
	public String processRegistration(Admin admin) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodeString = encoder.encode(admin.getPassword());
		admin.setPassword(encodeString);
		aRepository.save(admin);
		return "register_success";
	}
	@RequestMapping("/admin/home")
	public String viewUserList(Model model) {
		//List<Admin> uList = aRepository.findAll();
		//model.addAttribute("userlist",uList);
		return "admin_portal";
		
	}
	@GetMapping("/forgotPassword")
	public String forgotpassword(Model model) {
		return "forgotPassword";
	}
	@GetMapping("/student_dashboard")
	public String studentDashboard(Model model)
	{
		return "student_dashboard";
	}
}
