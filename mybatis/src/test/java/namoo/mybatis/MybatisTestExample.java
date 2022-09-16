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

import namoo.mybatis.ems.dto.Employee;
/**
 * XXXService 객체라고 생각....
 * @author 정충효
 *
 */
public class MybatisTestExample {
	
	private static final String namespace = "namoo.mybatis.ems.mapper.EmployeeMapper";
	
	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//mybatis 코드 부분
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "product");
		SqlSession sqlSession = sqlSessionFactory.openSession(); //sql 날리는 용 DAO 역할
 		System.out.println("sqlSession 생성 완료..");
		
		System.out.println("==================== 전체사원 조회 ========================");
		List<Employee> employeeList = sqlSession.selectList(namespace+".findAll");
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
		
		System.out.println("==================== 사원번호로 사원조회 ========================");
		int id = 200;
		Employee employee = sqlSession.selectOne(namespace + ".findById", id);//두번째 인자는 전달 값
		System.out.println(employee);
		
		System.out.println("==================== 사원번호로 급여조회 ========================");
		int salary = sqlSession.selectOne(namespace + ".findBySalary", id);
		System.out.println("받는 급여 : " + salary);
		
		System.out.println("==================== 급여범위로 사원조회 ========================");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("min", 3000);
		map.put("max",5000);
		List<Employee> salarybtw = sqlSession.selectList(namespace + ".findBySalaryRange",map);
		for(Employee sr : salarybtw) {
			System.out.println("3000<= 급여 <= 5000 : " + sr);
		}

		
	}
}
