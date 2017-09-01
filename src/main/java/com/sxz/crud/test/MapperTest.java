package com.sxz.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxz.crud.bean.Dept;
import com.sxz.crud.bean.Employee;
import com.sxz.crud.dao.DeptMapper;
import com.sxz.crud.dao.EmployeeMapper;

/**
 * 测试dao层
 * @author colin
 *@ContextConfiguration指定spring配置文件的位置
 *直接自动注入	@Autowired
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springContext.xml"})
public class MapperTest {
	@Autowired
	DeptMapper deptMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	/**
	 * 测试dept
	 */
	@Test
	public void tesCrudt(){
		//1.创建spring的ioc容器
		/*ApplicationContext ioc = new ClassPathXmlApplicationContext("springContext.xml");
		//2.从容器器中获取mapper
		DeptMapper bean=ioc.getBean(DeptMapper.class);
		System.out.println(bean);*/
		//System.out.println(deptMapper);
		//1.插入几个部门
		
		/*deptMapper.insertSelective(new Dept(1,"开发部")); 
		deptMapper.insertSelective(new Dept(2,"测试部")); */
		
		//2。生成员工
		//employeeMapper.insertSelective(new Employee(1,"jack","M","jack@maxmobi.com",1));
		//3.批量插入多个员工，可以执行批量操作的sqlsesion
		/*for(){
			
			employeeMapper.insertSelective(new Employee(1,"jack","M","jack@maxmobi.com",1));
		}*/

		EmployeeMapper mapper =sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++){
			String uid=UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@maxmobi.com",1));
			
		}

	}
}
