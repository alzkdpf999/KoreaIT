package namoo.springJPA;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.entity.user.User;
import namoo.springJPA.repository.user.UserRepository;

@SpringBootTest
@Transactional /* rollback 과 commit을 관리해줌 테스트에서는 롤백을 저절로 실행해줌 안쓰면 오토 커밋 */
@Slf4j
/**
 * JPA DATA 사용
 * 
 * @author 정충효
 *
 */
public class JPADataTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Disabled
	public void test5() {
		List<User> user = userRepository.findName("sp");
		log.info("{}", user);
	}

	@Test
	@Disabled
	public void test2() {
		List<User> findUser = userRepository.findAll();
		log.info("찾는 사용자{}",findUser);
	}
	@Test
	@Disabled
	@DisplayName("findName")
	public void test6() {
		List<User> user = userRepository.findName("a");
		for (User user2 : user) {
			log.info("이름 으로 찾기 {}", user2);
		}
		
	}
	@Test
	@DisplayName("lastname")
	void test7() {
		List<User> user = userRepository.findLastName("a");
		log.info("성으로 {}",user);
	}

}
