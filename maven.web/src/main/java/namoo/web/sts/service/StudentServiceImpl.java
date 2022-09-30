package namoo.web.sts.service;

import java.io.IOException;
import java.io.Reader;
import java.security.Provider.Service;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import namoo.student.common.factory.ServiceImpl;
import namoo.student.common.web.Params;
import namoo.web.sts.dto.Student;
import namoo.web.sts.mapper.StudentMapper;

public class StudentServiceImpl implements StudentService {
	
	SqlSession sqlSession = ServiceImpl.getInstance().setUp();
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	@Override
	public List<Student> findAll() {
		return mapper.findAll();
	}

	@Override
	public Student findBySsn(int ssn) {
		// TODO Auto-generated method stub
		return mapper.findBySsn(ssn);
	}

	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return mapper.findByName(name);
	}

	@Override
	public Student search(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.search(map);
	}

	@Override
	public void create(Student student) {
		// TODO Auto-generated method stub
		mapper.create(student);
		sqlSession.commit();
	}

	@Override
	public void delete(Map<String, Object> map) {
		mapper.delete(map);
		sqlSession.commit();
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		mapper.deleteAll();
		sqlSession.commit();
	}

	@Override
	public List<Student> sortStudent(String type) {
		// TODO Auto-generated method stub
		return mapper.sortStudent(type);
	}

	@Override
	public List<Student> listByPage(Params params) {
		// TODO Auto-generated method stub
		return mapper.listByPage(params);
	}

	@Override
	public int countByPage(Params params) {
		// TODO Auto-generated method stub
		return mapper.countByPage(params);
	}

	@Override
	public Student check(int ssn) {
		// TODO Auto-generated method stub
		return mapper.check(ssn);
	}
	
}