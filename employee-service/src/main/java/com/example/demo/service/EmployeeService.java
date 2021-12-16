package com.example.demo.service;

import com.example.demo.VO.DepartmentEmployeeVO;
import com.example.demo.entity.Employee;

public interface EmployeeService {
	DepartmentEmployeeVO getEmployee(int id);
	Employee saveEmployee(Employee employee);
	void delete(int id);
}
