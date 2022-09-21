package namoo.web.sts.service;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import namoo.web.sts.dto.Student;

public class StudentServiceImpl implements StudentService {
	SqlSession sqlSession;	
	public void setUp() {
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlSessionFactory.openSession();//Auto commit 아님
	}
	
	@Override
	public List<Student> listByPage(namoo.student.common.web.Params params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByPage(namoo.student.common.web.Params params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findBySsn(int ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> search(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> sortStudent(String type) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
