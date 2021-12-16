package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.VO.Department;
import com.example.demo.VO.DepartmentEmployeeVO;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Override
	public DepartmentEmployeeVO getEmployee(int id) {
		
		DepartmentEmployeeVO employeeVO = (DepartmentEmployeeVO) redisTemplate.opsForHash().get("EMPLOYEE", id);
	
		if(employeeVO == null) {
			
			Employee employee = employeeRepository.findById(id).get();
			Department department = restTemplate.getForObject("http://localhost:8082/department-service/departments/" +employee.getDepartmentId(), Department.class);
			
			employeeVO = new DepartmentEmployeeVO(employee, department);
			
			redisTemplate.opsForHash().put("EMPLOYEE", id, employeeVO);
			
			return employeeVO;
			
		}
		
		System.out.println("ĐÃ CACHED RỒI");
		return employeeVO;
		
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
		
	}

	@Override
	public void delete(int id) {
		employeeRepository.deleteById(id);
		redisTemplate.opsForHash().delete("EMPLOYEE",id);
		
	}



}
