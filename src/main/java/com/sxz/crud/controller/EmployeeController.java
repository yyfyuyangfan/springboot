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
 * ����Ա����������
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
		//�ⲻ��һ����ҳ��ѯ
		//�����ҵ���
		//�ڲ�ѯ֮ǰ����һ�·���������ҳ�룬�Լ�ÿҳ�Ĵ�С
		System.out.println("11111111111111111111111111111111");
		PageHelper.startPage(page, 5);
		//startpage�����ľ��������ѯ
		List emps = employeeServiceInf.getAll();
		//ʹ��paheinfo��װ,��װ����ϸ��Ϣ,5����������ʾ��ҳ��
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
