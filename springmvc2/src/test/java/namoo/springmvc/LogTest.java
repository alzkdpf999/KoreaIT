package namoo.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class LogTest {

	//import org.slf4j.Logger; 이거 써야함
	//Logger log = LoggerFactory.getLogger(LogTest.class);
	
	String name= "aaa";
	@Test
	void logTest() {
		//동적으로 받을 때 추가하는 방법 만약에 name이 디비에서 받아온 것이라고 가정하면 +연산자 절대 쓰면 안돼요
		log.trace("trace :{}",name);
		log.debug("debug :{}",name);
		log.info("info :{}" ,name);
		log.warn("warn :{}",name);
		log.error("error :{}",name);
	}
}
