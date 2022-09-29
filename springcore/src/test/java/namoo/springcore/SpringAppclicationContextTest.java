package namoo.springcore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import namoo.springcore.user.AppConfig;
import namoo.springcore.user.User;
import namoo.springcore.user.UserService;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class SpringAppclicationContextTest {

	ApplicationContext applicationContext;
	UserService userService;

	@BeforeEach
	public void setUp() {
		// 스프링 컨테이너 생성
		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//		applicationContext= new GenericApplicationContext("appConfig.xml");
		// 스프링 컨테이너로부터 원하는 빈을 검색
		// 등록된 빈의 이름으로 검색
//		userService = applicationContext.getBean("userService", UserService.class);
		//빈의 타입으로 검색하기
		userService = applicationContext.getBean(UserService.class);
	}

	@Test
	@Order(1)
	public void regist() {
		User user = new User("bangry", "1111", "jack", "bangry@naver.com");
		userService.registUser(user);
		System.out.println("1");
	}

	@Test
	@Order(2)
	public void find() {
		userService.findUser("bangry");
		System.out.println("2");
	}
}
