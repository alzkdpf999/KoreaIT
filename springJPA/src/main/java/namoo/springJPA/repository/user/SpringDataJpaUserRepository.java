package namoo.springJPA.repository.user;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import namoo.springJPA.entity.user.User;

public interface SpringDataJpaUserRepository extends JpaRepository<User, String> {
	List<User> findAllByNameContaining(String name);

	List<User> findAllByName(String name);

	List<User> findAllByNameStartingWith(String lastName);

	List<User> findAllByRegdateGreaterThanEqual(Date regdate);
	/*
	 * 위에와 같은 행동 이름이 너무 길면 밑에처럼 이름 아무렇게나 하고
	 * 
	 * @Query("select u from User u where u.regdate >= :readte") List<User>
	 * findByRegdate(Date regdate);
	 */

	// 날짜 범위에 의한 검색
	List<User> findAllByRegdateBetween(Date startRegdate, Date endRegdate);

	// 로그인할 때 사용가능
	User findByIdAndPasswd(String id, String passwd);

	/** 정렬 방법 1. 이름에 order by를 넣어주기 잘안씀 이름이 너무 길어짐 */
	List<User> findAllByOrderByNameAscEmailDesc();
	/** 졍렬 방법 2.  이 방식을 많이 쓰기*/
	List<User> findAllByNameContaining(String name, Sort sort);

	Page<User> findAllByIdContainingOrEmailContaining(String id, String email,Pageable pageable);
	
}
