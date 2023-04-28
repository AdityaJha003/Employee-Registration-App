package org.ncu.spring_jdbc_app.controller;

import java.util.List;

import org.ncu.spring_jdbc_app.entity.Employee;
import org.ncu.spring_jdbc_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class employeeController {

	// injecting employee service bean into employee controller
	@Autowired
	EmployeeService empService;

	@ModelAttribute(name = "employees")
	public Employee getEmployee() {
		return new Employee();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	// @GetMapping(value="/register")
	public String showForm() {
		return "employee-register";
	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	// @PostMapping(value="/process-form")
	public String processForm(@ModelAttribute("employee") Employee emp, Model model) {

		/* EmployeeService empService= new EmployeeServiceImpl(); */
		empService.createRecord(emp);

		return "confirmation";
	}

	@RequestMapping(value = "/showDetails", method = RequestMethod.GET)
	public String displayFormDetails(Model model) {
		List<Employee> emps = empService.loadEmployees();
		model.addAttribute("employees", emps);
		return "employee-list";

	}
	
	@RequestMapping(value = "/batchProcess", method = RequestMethod.POST)
	public String batchProcessOperation() {
		 List<Employee> emps = empService.loadEmployees();
		 empService.batchInsertRecord(emps);
		return "confirmation";
	}
	@RequestMapping(value="/sorta")
	public String sorta(Model model){
		List<Employee> emp= empService.Sortbysalarya();
		model.addAttribute("employee",emp);
		return "sort";
	}
	
	
	
	
	

//	// enable data binding - return entity bean
//	@Autowired
//	EmployeeService empService;
//	@ModelAttribute(value = "employee")
//	public Employee getEmployee() {
//		return new Employee();
//	}
//
//	// method to return the input form
//	@RequestMapping(value = "/form", method = RequestMethod.GET)
//	public String getEmployeeForm() {
//		return "employee-form";
//	}
//
//	// method to process the input form
//	@RequestMapping(value = "/process", method = RequestMethod.POST)
//	public String processEmployeeForm() {
//		return "employee-list";
//	}
}
