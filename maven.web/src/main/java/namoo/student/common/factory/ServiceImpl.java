package namoo.student.common.factory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import namoo.web.sts.dto.Student;
import namoo.web.sts.service.StudentService;
import namoo.web.sts.service.StudentServiceImpl;

public class ServiceImpl implements Service {
	private SqlSession sqlSession;	
	private StudentService studentService;
	private static ServiceImpl instance = new ServiceImpl();
	
	private ServiceImpl() {}
	public static ServiceImpl getInstance() {
		return instance;
	}
	public SqlSession setUp() {
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlSessionFactory.openSession();//Auto commit 아님
		return sqlSession;
	}
	public StudentService getStudentService() {
		if(studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}
}