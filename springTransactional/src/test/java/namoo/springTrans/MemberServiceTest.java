package namoo.springTrans;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springTrans.member.entity.Member;
import namoo.springTrans.member.repository.MemberHistoryRepository;
import namoo.springTrans.member.repository.MemberRepository;
import namoo.springTrans.member.service.MemberService;

@SpringBootTest
@Slf4j
public class MemberServiceTest {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberHistoryRepository memberHistoryRepository;

	/**
	 * MemberService @Transactional : OFF MemberRepository @Transactional:ON
	 * MemberHistoryRepository @Transactional:ON
	 */
// 회원, 회원이력 리포지토리 둘다 커밋 정상 처리
	@Test
	@Disabled
	public void completeTest() {
		Member member = new Member();
		member.setName("정상님");
		member.setAge(10);
		memberService.join(member);
		log.info("회원 및 회원이력 정상 등록 완료!");
	}
	
	/**
	* MemberService @Transactional : OFF
	* MemberRepository @Transactional:ON
	* MemberHistoryRepository @Transactional:ON
	*/
	// 회원 정상 커밋, 회원이력 롤백 -> 데이터 정합성 문제 발생
	@Test
	@Disabled
	public void failTest() {
	Member member = new Member();
	member.setName("비정상님");
	member.setAge(10);
	memberService.join(member);
	log.info("회원은 등록, 회원이력은 롤백!");
	}
	
	/**
	* MemberService @Transactional : ON
	* MemberRepository @Transactional:OFF
	* MemberHistoryRepository @Transactional:OFF
	*/
	// 단일 트랜잭션 -> 회원, 회원이력 리포지토리 둘다 커밋 정상 처리
	@Test
	@Disabled
	public void singleTxTest() {
	Member member = new Member();
	member.setName("단일트랜잭션님");
	member.setAge(10);
	memberService.join(member);
	log.info("회원 및 회원이력 정상 등록 완료!");
	}
	
	/**
	* MemberService @Transactional : ON
	* MemberRepository @Transactional:ON
	* MemberHistoryRepository @Transactional:ON
	*/
	// 트랜잭션 전파 -> 회원, 회원이력 리포지토리 둘다 커밋 정상 처리
	@Test
	@Disabled
	public void propagationSucessTest() {
	Member member = new Member();
	member.setName("트랜잭션전파님");
	member.setAge(10);
	memberService.join(member);
	log.info("회원 및 회원이력 정상 등록 완료!");
	}
	
	/**
	* MemberService @Transactional : ON
	* MemberRepository @Transactional:ON
	* MemberHistoryRepository @Transactional:ON
	*/
	// 트랜잭션 전파 -> 회원이력 리포지토리 예외 발생으로 둘다 롤백 처리
	@Test
	public void propagationFailTest() {
	Member member = new Member();
	member.setName("비정상님2");
	member.setAge(10);
	memberService.join(member);
	log.info("회원 및 회원이력 롤백!");
	}
	//회원 정보를 롤백 히스토리는 롤백을 원하면 멤버에만 넣어주면 된다. REQUIRES_NEW를 넣어준다.
}