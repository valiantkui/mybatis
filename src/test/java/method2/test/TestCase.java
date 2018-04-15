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
		 * Emp.class表示获取类对象，实践中证明任何一个类的类对象都可以用
		 * 即也可以将Emp.class换成TestCase.class
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
		 * getMapper方法返回一个符合Mapper映射器（EmpDao）要求的对象
		 */
		EmpDao dao = session.getMapper(EmpDao.class);
		Emp emp = new Emp();
		emp.setId("mingyuan");
		emp.setName("牛明远");
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
