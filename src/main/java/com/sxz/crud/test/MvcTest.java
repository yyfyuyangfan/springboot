package com.sxz.crud.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Param;
import com.sxz.crud.bean.Employee;

/**
 * 
 * ʹ��spring�Ĳ��Թ��ܲ����ṩ������
 * @author colin
 *
 */
//@WebAppConfiguration���԰�סע��spring�Լ�������
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springContext.xml","classpath:springmvc.xml"})
public class MvcTest {
	
	MockMvc mockMvc;
	@Autowired
	WebApplicationContext context;
	//@Beforeÿ�ζ����ʼ��
	@Before
	public void initMockMvc(){
		
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	@Test
	public void testPage() throws Exception{
	MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("apge","1")).andReturn();
	//����ɹ����������л���pageinfo,����������ȡ��	
	MockHttpServletRequest reqeust=result.getRequest();
	PageInfo pi = (PageInfo) reqeust.getAttribute("pageinfo");
	System.out.println("��ǰҳ�룺"+pi.getPageNum());
	System.out.println("��ҳ�룺"+pi.getPages());
	System.out.println("�ܼ�¼����"+pi.getTotal());
	System.out.println("����������Ҫ������ʾ��ҳ�룺"+pi.getNavigatepageNums());
	int [] nums = pi.getNavigatepageNums();
	for(int i : nums){
		System.out.println(""+i);
		
	}
	//��ȡԱ������
	List<Employee> list = pi.getList();
	for(Employee emp:list){
		System.out.println("ID:"+emp.getEmpid()+"==>name:"+emp.getEmpname());
		
		
	}
	}
	
}
