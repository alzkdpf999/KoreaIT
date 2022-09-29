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
	private static StudentServiceImpl instance = new StudentServiceImpl();
	
	private StudentServiceImpl() {}
	public static StudentServiceImpl getInstance() {
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
}