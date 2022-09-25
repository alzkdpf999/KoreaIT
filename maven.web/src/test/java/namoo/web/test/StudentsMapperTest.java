package namoo.web.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import namoo.student.common.web.Params;
import namoo.web.sts.dto.Student;
import namoo.web.sts.mapper.StudentMapper;
import namoo.web.sts.service.StudentServiceImpl;

public class StudentsMapperTest {
	SqlSession sqlSession;	
	@BeforeEach
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
	@Test
	@Disabled
	public void test1() {
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Student st = new Student();
		st.setSsn(4);
		st.setName("cack");
		st.setKorean(50);
		st.setEnglish(20);
		st.setMath(100);
		mapper.create(st);
		sqlSession.commit();
	}
	@Test
	@Disabled
	public void test2() {
		StudentServiceImpl.getInstance().setUp();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> list = mapper.findAll();
		for (Student employee : list) {
			System.out.println(employee);
		}
	}
	
	@Test
//	@Disabled
	public void test3() {
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Params params = new Params(1,10,3,"avg","all","","inverse");
		List<Student> list =mapper.listByPage(params);
		for(Student st : list) {
			System.out.println(st.avg());		
		}
		
	}
	@Test
	@Disabled
	public void test4() {
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Params params = new Params(1,10,3,"ssn","all","","inverse");
		int list =mapper.countByPage(params);
		System.out.println(list);
	}
	@Test
	@Disabled
	public void test5() {
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Student st = mapper.check(0);
		System.out.println(st);
	}
	@Test
	@Disabled
	public void test6() {
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Map<String, Object> test = new HashMap<>();
		test.put("name", "qw");
		test.put("ssn","2");
		mapper.delete(test);
		sqlSession.commit();
	}
	@Test
	@Disabled
	public void test7() {
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Map<String, Object> test = new HashMap<>();
		test.put("name", "qw");
		test.put("ssn","2");
		mapper.search(test);
	}
//	@Test
	
}
