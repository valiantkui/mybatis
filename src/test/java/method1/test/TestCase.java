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
		 * Emp.class��ʾ��ȡ�����ʵ����֤���κ�һ���������󶼿�����
		 * ��Ҳ���Խ�Emp.class����TestCase.class
		 */
		SqlSessionFactory ssf =
				ssfb.build(Emp.class
						.getClassLoader()
						.getResourceAsStream("SqlMapConfig.xml"));
		
		session = ssf.openSession();
	}
	
	@Test
	//sql����
	public void test1(){
		
		//����emp����Ȼ�󴫸�sqlMapConfig.xml
		Emp emp = new Emp();
		emp.setId("shaonan");
		emp.setName("����");
		emp.setPassword("123456");
		
		/*
		 * �������������ݿ�
		 * test��ʾ�����ռ䣬save��ʾMapper�����ռ��µ�id
		 * emp��ʾҪ����Ķ���
		 */
		int affectRows = session.insert("test.save",emp);
		System.out.println("��Ӱ����У�"+affectRows);
		
		//�޸Ĳ�����Ҫ�ύ����
		session.commit();
		session.close();//�ر���Դ
	}
	
	@Test
	//sql��ѯfindAll
	public void test2() {
		List<Emp> emps = session.selectList("test.findAll");
		
		System.out.println(emps);
		session.close();
	}
	
	@Test
	//sql��ѯfindOne
	public void test3() {
		Emp emp = session.selectOne("test.findOne", "yuankui");
		
		System.out.println(emp);
		session.close();
		
	}
	@Test
	//sql�޸�modify
	public void test4() {
		Emp emp = session.selectOne("test.findOne", "yuankui");
		
		emp.setName("����");
		emp.setPassword("666666");
		int affectRows = session.update("test.modify",emp);
		System.out.println("��Ӱ���������"+affectRows);
		
		session.commit();
		session.close();
	}
	@Test
	//sqlɾ��delete
	public void test5() {
		int affectRows = session.delete("test.delete", "yuankui");
		System.out.println("��Ӱ���������"+affectRows);
		session.commit();
		session.close();
	}
	

	
	@Test
	/*
	 * ��ѯ���ؽ��ΪMap���͵Ĳ���
	 */
	public void test6() {
		Map<String, Object> map = session.selectOne("test.findById2", "shaonan");
		System.out.println("��Ӱ���������"+map);
		session.close();
	}
	
	
	@Test
	
	public void test7() {
		Emp2 emp2 = session.selectOne("test.findById3", "shaonan");
		System.out.println(emp2);
	}
}
