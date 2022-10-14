package namoo.springJPA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.repository.user.UserRepository;

@SpringBootTest
@Slf4j
public class test {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void test() {
		log.info("{}",userRepository.findAll());
	}
	
}
