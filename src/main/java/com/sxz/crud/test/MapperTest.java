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
 * ����dao��
 * @author colin
 *@ContextConfigurationָ��spring�����ļ���λ��
 *ֱ���Զ�ע��	@Autowired
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
	 * ����dept
	 */
	@Test
	public void tesCrudt(){
		//1.����spring��ioc����
		/*ApplicationContext ioc = new ClassPathXmlApplicationContext("springContext.xml");
		//2.���������л�ȡmapper
		DeptMapper bean=ioc.getBean(DeptMapper.class);
		System.out.println(bean);*/
		//System.out.println(deptMapper);
		//1.���뼸������
		
		/*deptMapper.insertSelective(new Dept(1,"������")); 
		deptMapper.insertSelective(new Dept(2,"���Բ�")); */
		
		//2������Ա��
		//employeeMapper.insertSelective(new Employee(1,"jack","M","jack@maxmobi.com",1));
		//3.����������Ա��������ִ������������sqlsesion
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
