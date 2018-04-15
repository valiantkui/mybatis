package method1.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import method1.entity.Emp;
import method1.entity.Emp2;

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
						.getResourceAsStream("SqlMapConfig.xml"));
		
		session = ssf.openSession();
	}
	
	@Test
	//sql插入
	public void test1(){
		
		//创建emp对象，然后传给sqlMapConfig.xml
		Emp emp = new Emp();
		emp.setId("shaonan");
		emp.setName("绍男");
		emp.setPassword("123456");
		
		/*
		 * 插入数据向数据库
		 * test表示命名空间，save表示Mapper命名空间下的id
		 * emp表示要插入的对象
		 */
		int affectRows = session.insert("test.save",emp);
		System.out.println("受影响的行："+affectRows);
		
		//修改操作需要提交事务
		session.commit();
		session.close();//关闭资源
	}
	
	@Test
	//sql查询findAll
	public void test2() {
		List<Emp> emps = session.selectList("test.findAll");
		
		System.out.println(emps);
		session.close();
	}
	
	@Test
	//sql查询findOne
	public void test3() {
		Emp emp = session.selectOne("test.findOne", "yuankui");
		
		System.out.println(emp);
		session.close();
		
	}
	@Test
	//sql修改modify
	public void test4() {
		Emp emp = session.selectOne("test.findOne", "yuankui");
		
		emp.setName("奎奎");
		emp.setPassword("666666");
		int affectRows = session.update("test.modify",emp);
		System.out.println("受影响的行数："+affectRows);
		
		session.commit();
		session.close();
	}
	@Test
	//sql删除delete
	public void test5() {
		int affectRows = session.delete("test.delete", "yuankui");
		System.out.println("受影响的行数："+affectRows);
		session.commit();
		session.close();
	}
	

	
	@Test
	/*
	 * 查询返回结果为Map类型的测试
	 */
	public void test6() {
		Map<String, Object> map = session.selectOne("test.findById2", "shaonan");
		System.out.println("受影响的行数："+map);
		session.close();
	}
	
	
	@Test
	
	public void test7() {
		Emp2 emp2 = session.selectOne("test.findById3", "shaonan");
		System.out.println(emp2);
	}
}
