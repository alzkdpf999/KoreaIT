package namoo.springJPA;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
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
	public void test5() {
		List<User> user = userRepository.findName("sp");
		log.info("{}", user);
	}

	@Test
	public void test6() {
		List<User> user = userRepository.findByName("spring");
		log.info("{}", user);
	}
}
