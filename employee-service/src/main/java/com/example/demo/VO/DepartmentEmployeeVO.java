package com.example.demo.VO;

import java.io.Serializable;

import com.example.demo.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEmployeeVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee employee;
	private Department department;
	
}
