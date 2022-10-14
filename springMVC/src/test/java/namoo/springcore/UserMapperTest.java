package namoo.springcore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import namoo.springmvc.service.user.UserService;

@SpringBootTest
public class UserMapperTest {
	
//	@Autowired
//	@MockBean
	private  UserService userService;
	
	@Test
	public void findAll() {
//		List<User> list =userService.findUsers();
//		System.out.println(list);
		System.out.println("cals");
	}
}
