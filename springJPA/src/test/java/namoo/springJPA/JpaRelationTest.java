package namoo.springJPA;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.entity.user.Member;
import namoo.springJPA.entity.user.Team;
import namoo.springJPA.repository.user.JpaMemberRepository;
import namoo.springJPA.repository.user.JpaTeamRepository;

/**
 * JPArelation
 * 
 * @author 정충효
 *
 */
@SpringBootTest
@Slf4j
public class JpaRelationTest {
	@Autowired
	private JpaMemberRepository memberRepository;
	@Autowired
	private JpaTeamRepository teamRepository;

	@Test
	@Disabled
	@DisplayName("잘못된 방법")
	public void jpaTest() {
		// Team 생성 및 저장
		Team insertTeam = new Team();
		insertTeam.setName("TeamA");
		teamRepository.save(insertTeam);

		// Member 생성 및 저장
		Member insertMember = new Member();
		insertMember.setName("홍길동");
		insertMember.setAge(10);
		//insertMember.setTeamId(insertTeam.getId());
		memberRepository.save(insertMember);
		log.info("테이블 생성 및 저장 완료!");
		// 조회 시 2번 조회해야 한다.
		Optional<Member> optional = memberRepository.findById(insertMember.getId());
		if (optional.isPresent()) {
			Member findMember = optional.get();
			// 참조를 이용해서 팀정보 조회
			Optional<Team> optional2 = teamRepository.findById(insertTeam.getId());
			if (optional2.isPresent()) {
				Team findTeam = optional2.get();
				log.info("회원명, 팀명 : {}, {}", findMember.getName(), findTeam.getName());

			}
		}
	}
	
	@Test
	@DisplayName("이 방법을 사용해야함")
//	@Disabled
	public void test2() {
		// Team 생성 및 저장
		Team insertTeam = new Team();
		insertTeam.setName("TeamA");
		teamRepository.save(insertTeam);
		
		// Member 생성 및 저장
		Member insertMember = new Member();
		insertMember.setName("홍길동");
		insertMember.setAge(10);
		insertMember.setTeam(insertTeam); // 단방향 연관관계 설정(참조 저장)
		memberRepository.save(insertMember);
		log.info("테이블 생성 및 저장 완료!");
		
		// 한번만 조회하면 된다.
		Optional<Member> optional = memberRepository.findById(insertMember.getId());
		if(optional.isPresent()) {
		Member findMember = optional.get();
		// 참조를 이용해서 팀정보 조회
		Team findTeam = findMember.getTeam();
		log.info("회원명, 팀명 : {}, {}", findMember.getName(), findTeam.getName());

		// 연관관계 수정
		// 새로운 팀 생성
		Team teamB = new Team();
		teamB.setName("TeamB");
		teamRepository.save(teamB);
		// 기존 회원 팀 변경
		findMember.setTeam(teamB);
//		memberRepository.save(findMember);
		log.info("팀 정보 수정 완료: {}", findMember);
	}
	}

}