package namoo.springTrans.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Transactional
	public void order(Order order) throws NotEnoughMoneyException {
		log.info("===== order() 메소드 호출됨 =====");
		orderRepository.save(order); // 테이블에 저장
		log.info(">> 결제 프로세스 진입");
		if (order.getUsername().equals("런타임예외님")) {
			log.info("※ 시스템(런타임) 예외 발생 ※");
			throw new RuntimeException("시스템(런타임) 예외발생하였습니다.");
		} else if (order.getUsername().equals("잔고부족님")) {
			log.info("※ 잔고 부족 비즈니스 예외 발생 ※");
			order.setPayStatus("대기");
			throw new NotEnoughMoneyException("고객님 잔고가 부족합니다");
		} else {
			// 정상 승인
			log.info(">> 정상 승인");
			order.setPayStatus("완료");
		}
		log.info(">> 결제 프로세스 완료");
		log.info("===== order() 메소드 종료 =====");
	}
}
