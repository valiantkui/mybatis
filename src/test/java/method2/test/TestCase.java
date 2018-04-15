package method2.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import method2.entity.Emp;
import method2.dao.EmpDao;

public class TestCase {

	
	private SqlSession session;
	@Before
	public void init() {
		
		
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
		/*
		 * Emp.class��ʾ��ȡ�����ʵ����֤���κ�һ���������󶼿�����
		 * ��Ҳ���Խ�Emp.class����TestCase.class
		 */
		SqlSessionFactory ssf =
				ssfb.build(Emp.class
						.getClassLoader()
						.getResourceAsStream("SqlMapConfig2.xml"));
		
		session = ssf.openSession();
	}
	@Test
	public void test1() {
		/**
		 * getMapper��������һ������Mapperӳ������EmpDao��Ҫ��Ķ���
		 */
		EmpDao dao = session.getMapper(EmpDao.class);
		Emp emp = new Emp();
		emp.setId("mingyuan");
		emp.setName("ţ��Զ");
		emp.setPassword("123456");
		dao.save(emp);
		session.commit();
		session.close();
	}
	
	@Test
	public void test2() {
		EmpDao dao = session.getMapper(EmpDao.class);
		List<Emp> empList = dao.findAll();
		System.out.println(empList);
		
		session.close();
	}
	@Test
	public void test3() {
		EmpDao dao = session.getMapper(EmpDao.class);
		List<Emp> empList = dao.findAll();
		System.out.println(empList);
		
		session.close();
	}
	
}
