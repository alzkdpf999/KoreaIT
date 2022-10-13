package namoo.springJPA.repository.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import namoo.springJPA.entity.user.User;

/**
 * JPA 사용
 * @author 정충효
 *
 */
public interface UserRepository {
	
	/** 회원 등록 */
	public void create(User user);
	
	/** 회원 아이디로 회원 조회 */
	public User findById(String id);
	
	/** 회원 전체 목록 조회 */
	public  List<User> findAll();
	
	/** 회원 정보 수정 */
	public void update(User user);

}
