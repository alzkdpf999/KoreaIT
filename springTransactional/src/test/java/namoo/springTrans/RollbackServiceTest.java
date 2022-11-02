package namoo.springTrans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springTrans.Service.RollbackService;
import namoo.springTrans.Service.RollbackService.MyException;

@SpringBootTest
@Slf4j
class RollbackServiceTest {

	/*
	 * @Autowired private RollbackService rollbackService;
	 * 
	 * @Test void runtimeExceptionTest() { rollbackService.runtimeException(); }
	 * 
	 * @Test void checkedExceptionTest() throws MyException {
	 * rollbackService.checkedException(); }
	 * 
	 * @Test void rollbackForTest() throws MyException {
	 * rollbackService.rollbackFor(); }
	 */
}
