package namoo.springcore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import namoo.springcore.user.AppConfig2;
import namoo.springcore.user.User;
import namoo.springcore.user.UserService;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class SpringAppclicationContextTest2 {

	ApplicationContext applicationContext;
	UserService userService;

	@BeforeEach
	public void setUp() {
		// 스프링 컨테이너 생성
		//web지원안함
		applicationContext = new AnnotationConfigApplicationContext(AppConfig2.class);
		//타입으로 검색 이게 더 유용함
//		userService = applicationContext.getBean(UserService.class);
		//이름으로 검색
		userService = applicationContext.getBean("userServiceImpl",UserService.class);
		UserService userService2 = applicationContext.getBean("userServiceImpl",UserService.class);
		System.out.println(userService == userService2);
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
		System.out.println(userService.findUser("bangry"));
	}
}
