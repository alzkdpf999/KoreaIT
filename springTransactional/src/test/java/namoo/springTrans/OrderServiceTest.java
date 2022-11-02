package namoo.springTrans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springTrans.Service.NotEnoughMoneyException;
import namoo.springTrans.Service.Order;
import namoo.springTrans.Service.OrderService;

@SpringBootTest
@Slf4j
class OrderServiceTest {
	@Autowired
	private OrderService orderService;

	@Test
	public void completeTest() throws NotEnoughMoneyException {
		Order order = new Order();
		order.setUsername("정상님");
		orderService.order(order);
		log.info("주문 정상 처리 완료!");
	}

	@Test
	public void runtimeExceptionTest() throws NotEnoughMoneyException {
		Order order = new Order();
		order.setUsername("런타임예외님");
		orderService.order(order);
		log.info("시스템 예외로 롤백!");
	}

	@Test
	public void bizExceptionTest() {
		Order order = new Order();
		order.setUsername("잔고부족님");
		try {

			orderService.order(order);
			log.info("잔고 부족으로 비즈니스 예외 발생");

		} catch (NotEnoughMoneyException e) {
			e.printStackTrace();
			log.info("별도의 계좌로 입금 안내합니다.");

		}
	}

}
