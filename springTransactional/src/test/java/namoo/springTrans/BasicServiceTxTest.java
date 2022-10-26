package namoo.springTrans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springTrans.Service.BasicService;

@SpringBootTest
@Slf4j
class BasicServiceTxTest {

	// 실제 서비스 객체 대신에 트랜잭션을 처리해주는 프록시 객체가 스프링 빈에 등록되고,
	// 주입 받을 때도 실제 서비스 객체 대신에 프록시 객체가 주입된다.
	@Autowired
	private BasicService basicService;

	// AOP 프록시 객체 확인
	@Test
	public void checkProxy() {
		Object proxy = basicService.getClass();
		log.info("AOP 프록시객체 : {}", proxy);
	}

	// 트랜잭션 적용 확인
	@Test
	public void transactionTest() {
		basicService.txMethod();
		basicService.nonTxMethod();
	}

}
