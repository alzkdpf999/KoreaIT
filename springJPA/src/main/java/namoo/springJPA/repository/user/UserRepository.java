package namoo.springJPA.repository.user;

import java.util.List;

import namoo.springJPA.entity.user.User;

/**
 * JPA 사용 ===> JPADATA 사용
 * @author 정충효
 *
 */
public interface UserRepository {
	
	/** 회원 등록 */
	public void create(User user);
	
	/** 회원 아이디로 회원 조회 */
	/** 실제로 하면 optional로 받는게 더 좋음*/
	public User findById(String id);
	
	/** 회원 전체 목록 조회 */
	public  List<User> findAll();
	
	/** 회원 정보 수정 */
	public void update(User user);
	
	/** 회원 이름 검색*/
	public List<User> findName(String name);
	
	public List<User> findByName(String name);
}
