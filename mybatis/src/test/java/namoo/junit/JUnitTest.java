package namoo.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
import static java.lang.System.out;//이런식으로 하면 out.println만 쳐도 System.out.println으로 동작
import static java.lang.Math.*; //math.이라고 안해도 가능
*/
/**
 * Test 하는 과정
 * 
 * @author 정충효
 *
 */
//@TestMethodOrder(MethodOrderer.MethodName.class)//이렇게하면 알파벳 순서대로
public class JUnitTest {

	static SomeServiceImpl service;
	/*
	 * @Order(2)
	 * 
	 * @Order(1) 이거는 순서 지정
	 * 
	 * @Order(3)
	 */

	@BeforeEach // 선행작업 먼저 실행해라라는 뜻
	public void setUp() {
		System.out.println("BeforeEach");
		service = new SomeServiceImpl();
	}
	
	@BeforeAll// 테스트메소드 전에 딱 한번만 실행 단 static를 붙혀줘야 함 하지만 큰 의미가 없으면 그냥 BeforeEach를 씀
	public static void setUp2() {
		System.out.println("BeforeAll");
		service = new SomeServiceImpl(); //이 이후로 위에 변수에도 static 필요
	}
	
	@Test // @Test를 하면 import org.junit.jupiter.api.Test;가 생김
	@DisplayName("내가 원하는 이름으로 나오게 함")
	@Disabled //실행 안됌
	public void sumTest() {
		// System.out.println("나 호출됨.."); //System.out.println("나 호출됨..")는 에시를 보여주기 위해
		// 보통 안함
		System.out.println(service.sum(10, 20));
	}// public은 필수는 아님

	@Test
	@Disabled
	public void sumTest2() {
		System.out.println(10 + 20);
		assertEquals(30, service.sum(10, 20));//assert 쓰는것이 junit 처럼 쓰는 거지만 정 안돼면 sysout으로 
		
	}
	
	@Test
	public void test() {
		assertNotNull(service);
	}
	
	@Test
	@Timeout(value = 3)
	@Disabled
	public void checkTimeout(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterEach
	public void destroy() {
		System.out.println("테스트 메소드 실행 후 실행되는 메소드");
		/*
		 * 30 
		 * 테스트 메소드 실행 후 실행되는 메소드 
		 * 30 
		 * 테스트 메소드 실행 후 실행되는 메소드
		 * 
		 */
	}
	
	@ParameterizedTest
	@ValueSource(ints= {10,20,30})
	public void parameterValue(int value){
		System.out.println("전달 값:"+value);
	}
	
	@RepeatedTest(5)// 이렇게 하면 5번 실행
	void re(RepetitionInfo res) {
		assertEquals(5,res.getTotalRepetitions());
		System.out.println(res.getTotalRepetitions());
	}
	@Test
	@DisplayName("window에서만 작업 수행")
	void windowTask() {
		assumeTrue(System.getProperty("os.name").startsWith("Windows"));
	}
}
