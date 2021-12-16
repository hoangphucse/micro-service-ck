package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.VO.DepartmentEmployeeVO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{employeeId}")
	public DepartmentEmployeeVO getEmployee(@PathVariable("employeeId") Integer employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		employeeService.delete(employeeId);
	}
	
	
}
