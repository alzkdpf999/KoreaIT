package namoo.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import namoo.mybatis.ems.dto.Employee;
import namoo.mybatis.ems.mapper.EmployeeMapper;
import namoo.mybatis.ems.mapper.EmployeeMapper2;

public class EmployeeMapperTest2 {
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
		sqlSession = sqlSessionFactory.openSession();
	}
	
	@Test
	public void test1(){
		System.out.println("==================== 전체사원 조회 ========================");
		EmployeeMapper2 mapper = sqlSession.getMapper(EmployeeMapper2.class);
		List<Employee> list = mapper.findAll();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void test2(){
		System.out.println("==================== 사원번호로 사원조회 ========================");
		EmployeeMapper2 mapper = sqlSession.getMapper(EmployeeMapper2.class);
		Employee employee = mapper.findById(150);
		System.out.println(employee);
	}
	
	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}







