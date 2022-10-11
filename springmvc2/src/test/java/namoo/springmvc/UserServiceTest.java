package namoo.springmvc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import namoo.springmvc.dto.user.User;
import namoo.springmvc.service.user.UserService;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
//	@Disabled
	public void findAll() {
		List<User> list = userService.findUsers();
		System.out.println(list);
	}
	@Test
	public void find() {
		User user = userService.findUser("bangry");
		System.out.println(user);
	}
}






