package namoo.springTrans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springTrans.Service.CallService;

@SpringBootTest
@Slf4j
class CallServiceTxTest {

	@Autowired
	private CallService callService;

	@Test
	void printProxy() {
	log.info("callService class={}", callService.getClass());
	}
	@Test
	void internalCall() {
	callService.internal();
	}
	@Test
	void externalCall() {
	callService.external();
	}
}
