package namoo.springJPA;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.entity.user.Member;
import namoo.springJPA.entity.user.Team;
import namoo.springJPA.repository.user.JpaMemberRepository;
import namoo.springJPA.repository.user.JpaTeamRepository;

@Slf4j
public class JpaRelationtwoway {
	@Autowired
	private JpaMemberRepository memberRepository;
	@Autowired
	private JpaTeamRepository teamRepository;

	// ====================================== 양 방 향 부
	// 분========================================
	@Test
	@DisplayName("양방향 관계")
	@Disabled
	public void test3() {
		// Team 생성 및 저장
		Team insertTeam = new Team();
		insertTeam.setName("TeamA");
		teamRepository.save(insertTeam);
		// Member 생성 및 저장
		Member insertMember1 = new Member();
		insertMember1.setName("홍길동");
		insertMember1.setAge(10);
		insertMember1.setTeam(insertTeam);
		Member insertMember2 = new Member();
		insertMember2.setName("김길동");
		insertMember2.setAge(20);
		insertMember2.setTeam(insertTeam);
		memberRepository.save(insertMember1);
		memberRepository.save(insertMember2);

		// 트랜잭션 공부
		List<Member> list = insertTeam.getMembers();
		log.info("size: {}", list.size());
		for (Member mem : list) {
			log.info("등록회원{}", mem);
		}
	}

	@Test
	@DisplayName("조회 이 방법 사용해야 조회가능")
	@Transactional
	// 양방향은 거의 잘 안씀 그냥 팀을 통해 조회할때 같은 경우에만 사용
	public void test5() {
		Optional<Team> optional = teamRepository.findById(1L);
		Team team = optional.get();
		String teamName = team.getName();

		log.info("팀 이름 {}", teamName);
		List<Member> memberlist = team.getMembers();

		log.info("멤버 수{}", memberlist.size());
		for (Member me : memberlist) {
			log.info("회원 명{}", me.getName());
		}
	}

	@Test
	@Disabled
	public void addTest() {
		Team insertTeam = new Team();
		insertTeam.setName("TeamA");
		teamRepository.save(insertTeam);
		Member insertMember = new Member();
		insertMember.setName("홍길동");
		insertMember.setAge(10);
		// 이렇게하면 team_id에 null값이 들어감
		// 역방향(주인이 아닌 방향)만 연관관계 설정
		insertTeam.getMembers().add(insertMember);
		memberRepository.save(insertMember);
	}

	@Test
	public void addTest2() {
		/**
		 * 이 상태에서 DB에는 잘 들어감 하지만 리스트 찍으면 안나옴
		 */

		Team team = new Team();
		team.setName("TeamA");
		Member member1 = new Member();
		member1.setName("홍길동");
		member1.setAge(10);
		Member member2 = new Member();
		member2.setName("김길동");
		member2.setAge(10);
		member1.setTeam(team);
		member2.setTeam(team);
		List<Member> members = team.getMembers();
		log.info("회원수 : {}", members.size());
	}

	public void addTest3() {
		// 이 방식을 해야함
		Team team = new Team();
		team.setName("TeamA");
		Member member1 = new Member();
		member1.setName("홍길동");
		member1.setAge(10);
		Member member2 = new Member();
		member2.setName("김길동");
		member2.setAge(10);
		member1.setTeam(team);
		team.getMembers().add(member1);
		member2.setTeam(team);
		team.getMembers().add(member2);
		List<Member> list = team.getMembers();
		for (Member member : list) {
			log.info("회원명: {}", member.getName());
		}
	}

	//최종버전
	public void addTest5() {
		//최종 버전
		Team team = new Team();
		team.setName("TeamA");
		Member member1 = new Member();
		member1.setName("홍길동");
		member1.setAge(10);
		Member member2 = new Member();
		member2.setName("김길동");
		member2.setAge(10);
		member1.setTeam(team);
		team.getMembers().add(member1);
		member2.setTeam(team);
		team.getMembers().add(member2);
		List<Member> list = team.getMembers();
		for (Member member : list) {
			log.info("회원명: {}", member.getName());
		}
	}
}
