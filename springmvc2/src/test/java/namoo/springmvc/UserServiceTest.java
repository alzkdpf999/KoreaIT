package namoo.springmvc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import namoo.springmvc.dto.user.User;
import namoo.springmvc.service.user.UserService;

@SpringBootTest
@Transactional /*rollback 과 commit을 관리해줌 테스트에서는 롤백을 저절로 실행해줌 안쓰면 오토 커밋*/ 
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
	@Test
	public void regist() {
		User user = new User();
		user.setId("spring");
		user.setEmail("spring");
		user.setName("spring");
		user.setPasswd("spring");
		userService.registUser(user);
		System.out.println(user);
		
	}
}






