package method2.dao;

import java.util.List;

import method2.entity.Emp;

/**
 * Mapperӳ����
 * @author KUIKUI
 *
 */
public interface EmpDao {
	public void save(Emp emp );
	public List<Emp> findAll();
}
