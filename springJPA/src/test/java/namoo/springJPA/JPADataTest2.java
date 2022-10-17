package namoo.springJPA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.entity.user.User;
import namoo.springJPA.repository.user.SpringDataJpaUserRepository;

@SpringBootTest
@Transactional /* rollback 과 commit을 관리해줌 테스트에서는 롤백을 저절로 실행해줌 안쓰면 오토 커밋 */
@Slf4j
/**
 * JPA DATA 사용
 * 
 * @author 정충효
 *
 */
public class JPADataTest2 {
	/*
	 * UserRepository,jpaUserRepositoryDATA에 넣기 귀찮음 그래서 바로 연결시키기
	 */
	@Autowired
	private SpringDataJpaUserRepository re;

	@Test
	@DisplayName("한번에 연결 containing")
	@Disabled
	void test1() {
		String name = "a";
		List<User> users = re.findAllByNameContaining(name);
		log.info("{}", users);
	}

	@Test
	@DisplayName("옵션 검색 방법 ")
	@Disabled
	void test2() {
		String Type = "name";
		String Value = "on";
		List<User> list = null;
		switch (Type) {
		case "id":
			Optional<User> optional = re.findById(Value);
			if (optional.isEmpty()) {
				throw new RuntimeException("존재 안함");
			}
			list = new ArrayList<User>();
			list.add(optional.get());
			break;
		case "name":
			list = re.findAllByNameContaining(Value);
			break;
		default:
			list = re.findAll();
		}
		log.info("검색 결과타입:{}, 결과:{}",Type,list);
	}
	
	@Test
	@DisplayName("날짜 검색방법 Date 사용법")
	@Disabled
	void test3() throws ParseException {
		Date searchRegdate = new SimpleDateFormat("yy/MM/dd").parse("22/10/10"); 
		System.out.println(searchRegdate);
		List<User> list = re.findAllByRegdateGreaterThanEqual(searchRegdate);
		log.info("날짜 검색 :{}, {}", list.size(), list);
	}
	
	@Test
	@DisplayName("날짜 검색방법 Date 사용법 btn 사용")
	@Disabled
	void test4() throws ParseException {
	Date startDate = new SimpleDateFormat("yy/MM/dd").parse("22/07/24");
	Date endDate = new SimpleDateFormat("yy/MM/dd").parse("22/10/15");
	List<User> list = re.findAllByRegdateBetween(startDate, endDate);
	log.info("날짜범위 검색 :{}, {}", list.size(), list);
	}
	
	@Test
	@DisplayName("로그인할때 쓸 수 있는")
	@Disabled
	void test5() {
		User loginUser = re.findByIdAndPasswd("conan" , "coan");
		
		log.info("로그인 결과:{}",loginUser);
	}

	@Test
	@DisplayName("sort 이용하기 ")
	@Disabled
	void test6() {
		String name = "a";
		
		//List<User> list = userRepository.findAllByNameContaining(name, Sort.by("name"));
		//List<User> list = userRepository.findAllByNameContaining(name, Sort.by("name").descending());
		List<User> users = re.findAllByNameContaining(name,Sort.by("name").and(Sort.by("regdate")));
//		List<User> users = re.findAll(Sort.by("name").ascending()); 디폴트 
//		List<User> users = re.findAll(Sort.by("name").ascending());
		for (User user : users) {
			log.info("정렬 사용하기 :{}", user);
		}
		
	}
	
	@Test
	@DisplayName("페이징 처리 ")
	@Disabled
	void test7() {
		/** 0부터 시작 */
		Pageable pageable = PageRequest.of(1, 5,Sort.by("name")); //요청페이지 :2, 페이지당 5개 씩,이름 정렬
		Page<User> pageResults = re.findAll(pageable);
		log.info("목록: {}" , pageResults.getContent());
		log.info("전체목록 개수: {}" , pageResults.getTotalElements());
		log.info("현재페이지 목록 개수: {}" , pageResults.getNumberOfElements());
		log.info("전체페이지 개수: {}" , pageResults.getTotalPages());
		log.info("페이지당 목록 개수 {}: " , pageResults.getSize());
		log.info("현재 페이지 {}: " , pageResults.getNumber());
		log.info("처음으로 존재여부 {}: " , pageResults.isFirst()); //현재 페이지가 처음페이지인지
		log.info("이전페이지 존재여부 {}: " , pageResults.hasPrevious());
		log.info("다음페이지 존재여부 {}: " , pageResults.hasNext());
		log.info("마지막으로 존재여부 {}: " , pageResults.isLast());//현재 페이지가 마지막 페이지인지
	}
	
	@Test
	@DisplayName("페이징 처리 겸 검색기능")
	void test8() {
		String value = "on";
		Pageable pageable = PageRequest.of(0, 2);
		Page<User> pageResult = re.findAllByIdContainingOrEmailContaining(value, value, pageable);
		log.info("목록{}",pageResult.getContent());
		log.info("전체목록 개수: {}",pageResult.getTotalElements());
		log.info("현재 페이지 목록 개수:{}",pageResult.getNumberOfElements());
		log.info("이전페이지 존재여부 {}: " , pageResult.hasPrevious());
		log.info("다음페이지 존재여부 {}: " , pageResult.hasNext());
		log.info("마지막으로 존재여부 {}: " , pageResult.isLast());
	}
}
