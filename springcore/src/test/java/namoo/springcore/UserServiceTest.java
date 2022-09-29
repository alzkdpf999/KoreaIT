package namoo.springcore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import namoo.springcore.user.AppConfig;
import namoo.springcore.user.User;
import namoo.springcore.user.UserService;
import namoo.springcore.user.UserServiceImpl;

public class UserServiceTest {
	UserService userService;

	@BeforeEach
	public void setUp() {
		//userService = new UserServiceImpl();
		userService = new AppConfig().userService();
	}

	@Test
	@DisplayName("등록")
	@Disabled
	public void registUser() {
		User user = new User("bangry", "1111", "jack", "bangry@naver.com");
		userService.registUser(user);
	}
	@Test
	public void 전체리스트() {
		User user = new User("bangry", "1111", "jack", "bangry@naver.com");
		System.out.println(userService.findUsers());
	}
}
