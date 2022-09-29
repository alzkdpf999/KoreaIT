package namoo.springcore.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 객체를 생성하고 생성된 객체들 간의 의존 관게를 주입하는(DI) 역할의 클래스
 * 어셈블러 클래스 
 * @author 정충효
 * 
 */
@Configuration
public class AppConfig {
	//메소드 이름으로 빈에 등록됨
	@Bean
	public UserRepository userRepository() {
		return new MemoryUserRepository();
	}
	@Bean 
	public UserService userService() {
		return new UserServiceImpl(userRepository());
	}
}
