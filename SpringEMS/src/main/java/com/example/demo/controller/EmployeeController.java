package com.example.demo.controller;

import com.example.demo.service.EmployeeService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;

@Controller
public class EmployeeController {
	
	public EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/employees")
	public String getEmployeeDetails(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees",employees);
		return "employees";
	}
	
	@GetMapping("/addEmployee")
	public String showAddForm(Model model) {
		model.addAttribute("employee",new Employee());
		return "addEmployee";
	}
	
	@PostMapping("/saveEmployee")   
	public String saveEmployee(Employee employee) {
	    employeeService.saveEmployee(employee);
	    return "redirect:/employees";
	}
}
