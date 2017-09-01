package com.sxz.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sxz.crud.bean.Employee;
import com.sxz.crud.dao.EmployeeMapper;

@Service
public class EmployeeService implements employeeServiceInf {

	@Autowired
	public EmployeeMapper employeeMapper; 
	/**
	 * 查询所有员工
	 * @return
	 */
	
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		System.out.println("this is service");
		return employeeMapper.selectByExamplewithdept(null);
	}
	
	public Employee getEmp(Integer empid){	
		return employeeMapper.selectByPrimaryKey(empid);
	}

}
