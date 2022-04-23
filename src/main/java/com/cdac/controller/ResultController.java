package com.cdac.controller;

import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.entity.Result;
import com.cdac.service.ResultService;

@Controller
public class ResultController {
	
	@Autowired
	private ResultService service;
	
	@GetMapping("/admin/add_result")
	private String addResult(Model model) {
		//System.out.println("inside register student");
		model.addAttribute("result", new Result());
		return "AddResult";
	}
	@PostMapping("/admin/result")
	public String saveResult(@ModelAttribute("result") Result result) {
		service.save(result);
		return "admin_portal";
	}
	
	@GetMapping("/admin/viewresult")
	public String viewResult(Model model) {
	    List<Result> listResult = service.listAll();
	    model.addAttribute("listResult", listResult);
	     
	    return "ViewResult";
	}
	
	@RequestMapping("/admin/subject_edit/{student}")
	public ModelAndView showEditClassPage(@PathVariable(name = "student") int id) {
	    ModelAndView mav = new ModelAndView("ResultById");
	    List<Result> result = service.getResultById(id);
	    mav.addObject("result", result);
	     
	    return mav;
	}
	
	

}
