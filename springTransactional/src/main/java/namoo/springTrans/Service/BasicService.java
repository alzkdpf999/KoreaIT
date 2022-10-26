package namoo.springTrans.Service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicService {
	@Transactional
	// 트랜잭션 AOP 적용 대상
	public void txMethod() {
	log.info("txMethod() 메소드 실행...");
	// 현재 쓰레드에 트랜잭션이 적용되어 있는지 확인
	// 결과가 true 면 트랜잭션이 적용됨을 의미
	boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
	log.info("트랜잭션 active = {}", txActive);
	}
	
	public void nonTxMethod() {
	log.info("nonTxMethod() 메소드 실행...");
	boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
	log.info("트랜잭션 active = {}", txActive);
	}
}
