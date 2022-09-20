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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import namoo.mybatis.ems.dto.Employee;
import namoo.mybatis.ems.mapper.EmployeeMapper;
/**
 * Layered Archetecture 기반에서 Service 클래스 역할이라 가정
 * @author 정충효
 *
 */
public class EmployeeMapperTest {
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
	public void test1(){
		System.out.println("==================== 전체사원 조회 ========================");
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> list = mapper.findAll();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	@Test
	@Disabled
	public void test2(){
		System.out.println("==================== 사원번호로 사원조회 ========================");
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		System.out.println(mapper);
		Employee employee = mapper.findById(200);
		System.out.println(employee);
	}
	@Test
	@Disabled
	public void test3() {
		System.out.println("==================== 성으로 사원조회 ========================");
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> emp = mapper.findByLastName("A%");
		for(Employee em : emp) {
			System.out.println(em);
		}
	}
	@Test
	public void test4() {
		System.out.println("==================== 사원 정보 수정 ========================");
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		Employee emp = new Employee();
		emp.setSalary(60000);
		emp.setFirstName("라");
		emp.setLastName("볶이");
		emp.setId(200);
		mapper.update2(emp);
		sqlSession.commit();
	}
	
	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}







