package namoo.springcore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import namoo.springmvc.dto.user.User;
import namoo.springmvc.service.user.UserService;
@SpringBootTest(classes = UserMapperTest.class)
public class UserMapperTest {
	
	@Autowired
	@MockBean
	private UserService userService;
	
	@Test
	public void findAll() {
		List<User> list =userService.findUsers();
		System.out.println(list);
	}
}
