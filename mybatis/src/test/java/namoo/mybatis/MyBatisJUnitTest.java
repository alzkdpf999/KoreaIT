package namoo.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import namoo.mybatis.ems.dto.Employee;

public class MyBatisJUnitTest {
	
	private static final String namespace = "namoo.mybatis.ems.mapper.EmployeeMapper";
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
		sqlSession = sqlSessionFactory.openSession(); // Auto Commit
		//sqlSession = sqlSessionFactory.openSession(false);
		sqlSession = sqlSessionFactory.openSession();
		System.out.println("sqlSession 생성 완료..");
	}
	
	@Test
	@Disabled
	public void test1(){
		System.out.println("==================== 전체사원 조회 ========================");
		List<Employee> employeeList = sqlSession.selectList(namespace+".findAll");
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}
	
	@Test
	@Disabled
	public void test2(){
		System.out.println("==================== 사원번호로 사원조회 ========================");
		int id = 200;
		Employee employee = sqlSession.selectOne(namespace + ".findById", id);
		System.out.println(employee);
	}
	
	@Test
	@Disabled
	public void test3(){
		System.out.println("==================== 사원번호로 급여조회 ========================");
		int id = 200;
		int salary = sqlSession.selectOne(namespace + ".findBySalary", id);
		System.out.println("받는 급여 : " + salary);
	}
	
	@Test
	@Disabled
	public void test4(){
		System.out.println("==================== 급여범위로 사원검색 ========================");
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("min", 10000);
		params.put("max", 100000);
		List<Employee> employeeList = sqlSession.selectList(namespace + ".findBySalaryRange", params);
		for (Employee emp : employeeList) {
			System.out.println(emp);
		}
	}
	
	@Test
	@Disabled
	public void test5(){
		System.out.println("==================== 성으로 사원 와일드카드 검색 ========================");
		String searchName = "e";
		searchName = "%" + searchName.toUpperCase() + "%"; // E(e)가 포함된 모든 성
		List<Employee> employeeList = sqlSession.selectList(namespace + ".findByLastName", searchName);
		for (Employee emp : employeeList) {
			System.out.println(emp);
		}
	}
	
	@Test
	@Disabled
	public void test6(){
		System.out.println("==================== 부서명 포함 사원정보 조회(조인) ========================");
		List<Map<String, Object>> list = sqlSession.selectList(namespace + ".findByJoin");
		for (Map<String, Object> row : list) {
			Number empId = (Number) row.get("id");
			String firstName = (String) row.get("firstName");
			String lastName = (String) row.get("lastName");
			String departmentName = (String) row.get("departmentName");
			System.out.println(empId + "\t" + firstName + "\t" + lastName + "\t" + departmentName);
		}
	}
	
	@Test
	@Disabled
	public void test7(){
		System.out.println("==================== ResultMap을 이용한 전체사원 조회 ========================");
		List<Employee> employeeList = sqlSession.selectList(namespace + ".findByAll2");
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}
	
	@Test
	@Disabled
	public void test8(){
		Employee emp = new Employee();
		emp.setFirstName("KiJung");
		emp.setLastName("Kim");
		emp.setEmail("kimkijung@gmail.com");
		emp.setPhoneNumber("010.9179.87087");
		emp.setHireDate("2016-11-02");
		emp.setJobId("IT_PROG");
		emp.setSalary(50000);
		emp.setManagerId(150);
		emp.setDepartmentId(60);

		sqlSession.insert(namespace + ".create", emp);
		//sqlSession.commit();
		// sqlSession.rollback();
		System.out.println("신규사원 등록 완료");
	}
	
	@Test
	@Disabled
	public void test9(){
		Employee emp = new Employee();
		emp.setId(200);
		emp.setFirstName("볶이");
		emp.setLastName("떡");
		emp.setSalary(70000);
		sqlSession.update(namespace + ".update", emp);
		sqlSession.commit();
		System.out.println("사원정보 수정 완료");
	}
	
	@Test
	public void test10(){
		System.out.println("==================== 검색타입별 사원 검색(동적SQL 활용) ========================");
		Map<String, Object> searchParams = new HashMap<String, Object>();
//		searchParams.put("type", "id");
//		searchParams.put("value", 150);

		searchParams.put("type", "name");
		searchParams.put("value", "E%");

		List<Employee> employeeList = sqlSession.selectList(namespace + ".search", searchParams);
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}
	
	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}







