package namoo.springJPA.Service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {
	public void biz1() {
		log.info("biz1 메소드 실행");
	}
	public void biz2() {
		log.info("biz2 메소드 실행");
	}
}
