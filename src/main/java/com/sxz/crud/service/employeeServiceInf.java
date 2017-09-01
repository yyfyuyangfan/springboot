package com.sxz.crud.service;

import java.util.List;

import com.sxz.crud.bean.Employee;

public interface employeeServiceInf {

	public List<Employee> getAll();
	public Employee getEmp(Integer empid);
	
}
