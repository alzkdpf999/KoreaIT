package namoo.springTrans.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springTrans.member.entity.Member;
import namoo.springTrans.member.repository.MemberHistoryRepository;
import namoo.springTrans.member.repository.MemberRepository;
import namoo.springTrans.memberHistory.entity.MemberHistory;
@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberHistoryRepository memberHistoryRepository;

	/**
	 * 회원을 등록하면서 회원이력을 함께 남기는 비즈니스 로직 테스트를 위해 트랜잭션은 설정하지 않음
	 */
	@Transactional
	public void join(Member member) {
		log.info("== MemberService.join() 호출 시작 ==");
		log.info("-- memberRepository 호출 시작 --");
		memberRepository.save(member);
		log.info("-- memberRepository 호출 종료 --");
		log.info("-- memberHistoryRepository 호출 시작 --");
		MemberHistory memberHistory = new MemberHistory();
		memberHistory.setMessage(member.getName());
		memberHistory.setMember(member);
		memberHistoryRepository.save(memberHistory);
		log.info("-- memberHistoryRepository 호출 종료 --");
		log.info("== MemberService.join() 호출 종료 ==");
	}

	/**
	 * join()과 같은 기능을 수행 회원이력 저장시 예외가 발생하면 예외 처리 테스트를 위해 트랜잭션은 설정하지 않음
	 */
	@Override
	public void joinV2(Member member) {
		log.info("== MemberService.joinV2() 호출 시작 ==");
		log.info("-- memberRepository 호출 시작 --");
		memberRepository.save(member);
		log.info("-- memberRepository 호출 종료 --");
		log.info("-- memberHistoryRepository 호출 시작 --");
		MemberHistory memberHistory = new MemberHistory();
		memberHistory.setMessage(member.getName());
		memberHistory.setMember(member);
		try {
			memberHistoryRepository.save(memberHistory);
		} catch (RuntimeException e) {
			log.info("회원 이력 저장에 실패했습니다. historyMessage={}", memberHistory.getMessage());
		}
		log.info("-- memberHistoryRepository 호출 종료 --");
		log.info("== MemberService.joinV2() 호출 종료 ==");
	}

}
