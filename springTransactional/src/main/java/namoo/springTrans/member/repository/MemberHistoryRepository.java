package namoo.springTrans.member.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springTrans.memberHistory.entity.MemberHistory;

@Repository
@Slf4j
public class MemberHistoryRepository {
	@Autowired
	private EntityManager entityManager;

	@Transactional
	public void save(MemberHistory memberHistory) {
		log.info("- MemberHistory 저장");
		entityManager.persist(memberHistory);
// 트랜잭션 전파 롤백 테스트를 위해 런타임 예외 발생
		if (memberHistory.getMessage().contains("비정상님")) {
			log.info("MemberHistory 저장 시 예외 발생...");
			throw new RuntimeException("회원이력 저장시 예외 발생");
		}
	}

	public Optional<MemberHistory> find(String message) {
		Query query = entityManager.createQuery("select h from MemberHistory h where h.message=:message",
				MemberHistory.class);
		return query.setParameter("message", message).getResultList().stream().findAny();

	}
}