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
 * 使用spring的测试功能测试提供的请求
 * @author colin
 *
 */
//@WebAppConfiguration可以帮住注入spring自己的容器
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springContext.xml","classpath:springmvc.xml"})
public class MvcTest {
	
	MockMvc mockMvc;
	@Autowired
	WebApplicationContext context;
	//@Before每次都会初始化
	@Before
	public void initMockMvc(){
		
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	@Test
	public void testPage() throws Exception{
	MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("apge","1")).andReturn();
	//请求成功后，请求域中会有pageinfo,从请求域中取出	
	MockHttpServletRequest reqeust=result.getRequest();
	PageInfo pi = (PageInfo) reqeust.getAttribute("pageinfo");
	System.out.println("当前页码："+pi.getPageNum());
	System.out.println("总页码："+pi.getPages());
	System.out.println("总纪录数："+pi.getTotal());
	System.out.println("在用诶按需要连续显示的页码："+pi.getNavigatepageNums());
	int [] nums = pi.getNavigatepageNums();
	for(int i : nums){
		System.out.println(""+i);
		
	}
	//获取员工数据
	List<Employee> list = pi.getList();
	for(Employee emp:list){
		System.out.println("ID:"+emp.getEmpid()+"==>name:"+emp.getEmpname());
		
		
	}
	}
	
}
