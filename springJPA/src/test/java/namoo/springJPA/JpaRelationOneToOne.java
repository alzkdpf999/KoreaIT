package namoo.springJPA;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.entity.user.Locker;
import namoo.springJPA.entity.user.Member;
import namoo.springJPA.repository.user.JpaLockerRepository;
import namoo.springJPA.repository.user.JpaMemberRepository;

@Slf4j
public class JpaRelationOneToOne {
	@Autowired
	private JpaMemberRepository memberRepository;
	@Autowired
	private JpaLockerRepository jpaLockerRepository;
	public void insert() {
		Locker locker = new Locker();
		locker.setName("ss");
		jpaLockerRepository.save(locker);
		
		Member member = new Member();
		member.setName("jack");
		member.setAge(30);
		member.setLocker(locker);
		memberRepository.save(member);
	}
	
	public void test() {
		Optional<Locker> option = jpaLockerRepository.findById(3L);
		log.info("라커명{}" ,option.get().getName());
		log.info("라커주인{}" ,option.get().getMember().getName());
	}
}
