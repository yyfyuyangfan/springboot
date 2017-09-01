package com.sxz.crud.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxz.crud.service.employeeServiceInf;

/**
 * 处理员工请求请求
 * 
 * @author colin
 *
 */

@Controller
public class EmployeeController {
	
	@Autowired
	public employeeServiceInf employeeServiceInf;

	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="page",defaultValue="1") Integer page,Model model){
		//这不是一个分页查询
		//引入分业插件
		//在查询之前调用一下方法，传入页码，以及每页的大小
		System.out.println("11111111111111111111111111111111");
		PageHelper.startPage(page, 5);
		//startpage紧跟的就是这个查询
		List emps = employeeServiceInf.getAll();
		//使用paheinfo包装,封装了详细信息,5代表连续显示的页数
		PageInfo pa=new PageInfo(emps,5);
	
		model.addAttribute("pageinfo", pa);
		System.out.println("excute last");
		return "list";
	}
	
	@RequestMapping(value="/emp/{empid}" ,method=RequestMethod.GET)
	public String getEmp(@PathVariable("empid") Integer empid){
		System.out.println("this is emp:"+empid);
		/*Employee emp = employeeService.getEmp(empid);*/
		//System.out.println(emp.getEmail());
		return "list";
	} 
}
