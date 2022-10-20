package namoo.springJPA;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.entity.user.User;
import namoo.springJPA.repository.user.UserRepository;

@SpringBootTest
@Transactional /*rollback 과 commit을 관리해줌 테스트에서는 롤백을 저절로 실행해줌 안쓰면 오토 커밋*/ 
@Slf4j
/**
 * JPATest
 * @author 정충효
 *
 */
public class JpaRelationTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	@Disabled
	public void test1() {
		List<User> list = userRepository.findAll();
		log.info("실행하는 객체 출력 :::{}",userRepository.getClass().getName());
		log.info("사용자 수 {}",list.size());
		log.info("사용자 목록 {}",list);
	}
	
	@Test
	@Disabled
	public void test2() {
		User findUser = userRepository.findById("bangry");
		log.info("찾는 사용자{}",findUser);
	}
	
	@Test
//	@Commit//실제 반영을 해보고 싶으면 이걸 선언
	@Disabled
	public void test3() {
		User user = new User();
		user.setEmail("emailporm@naver.com");
		user.setId("idport");
		user.setPasswd("pswport");
		user.setName("nameport");
		userRepository.create(user);
		log.info("사용자 생성{}",user);
		
	}

	@Test
//	@Commit//실제 반영을 해보고 싶으면 이걸 선언
	@Disabled
	public void test4() {
		User user = new User();
		user.setEmail("emailportup@naver.com");
		user.setId("idport");
		user.setPasswd("pswupda");
		user.setName("nameport");
		userRepository.update(user);
		log.info("사용자 생성{}",user);
	}
	@Test
//	@Disabled
	public void test5() {
		List<User> user =  userRepository.findName("sp");
		log.info("{}",user);
	}
	@Test
	public void test6() {
		List<User> user =  userRepository.findByName("spring");
		log.info("{}",user);
	}
	
}
