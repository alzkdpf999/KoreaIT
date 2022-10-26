package namoo.springTrans.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CallService {

	public void external() {
		log.info("Called external");
		printTxInfo();
		// 내부 메소드 호출 시 트랜잭션 적용 안됨
		internal();
	}

	@Transactional
	public void internal() {
		log.info("Called internal");
		printTxInfo();
	}

	private void printTxInfo() {
		boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션 active={}", txActive);
	}
}
