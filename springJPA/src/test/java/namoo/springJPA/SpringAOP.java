package namoo.springJPA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.Service.MemberService;

@SpringBootTest
@Slf4j
public class SpringAOP {

		@Autowired
		private MemberService memberService;
		
		@Test
		public void join() {
			memberService.biz1();
			memberService.biz2();
			
		}
}
