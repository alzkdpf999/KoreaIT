package namoo.springmvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springmvc.dto.user.User;
import namoo.springmvc.service.user.UserService;

@SpringBootTest
@Transactional /*rollback 과 commit을 관리해줌 테스트에서는 롤백을 저절로 실행해줌 안쓰면 오토 커밋*/ 
@Slf4j
class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	@Disabled
	public void findAll() {
		List<User> list = userService.findUsers();
		System.out.println(list);
	}
	@Test
	@Disabled
	public void find() {
		User user = userService.findUser("bangry");
		System.out.println(user);
	}
	@Test
	@Disabled
	public void regist() {
		User user = new User();
		user.setId("spring12");
		user.setEmail("spring32");
		user.setName("spring32");
		user.setPasswd("spring32");
		userService.registUser(user);
		System.out.println(user);
		
	}
	@Test
	public void update() {
		String id ="spring";
		User user = new User();
		user.setId("springup");
		user.setEmail("springup");
		user.setName("springup");
		user.setPasswd("springup");
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("id",id);
		userService.updateUser(map);
		log.info("{}",userService.findUser(id));
	}
}






