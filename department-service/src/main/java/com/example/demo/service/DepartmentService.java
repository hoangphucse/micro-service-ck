package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentService {
	List<Department> getDepartments();

	Department getById(int id);
	
	Department save(Department department);
	
}
