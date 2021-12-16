package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping()
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.save(department);
	}
	
	@GetMapping()
	public List<Department> getAll() {
		return departmentService.getDepartments();
	}
	
	@GetMapping("/{departmentId}")
	public Department getDepartment(@PathVariable("departmentId") Integer departmentId) {
		return departmentService.getById(departmentId);
	}
	

	
}
