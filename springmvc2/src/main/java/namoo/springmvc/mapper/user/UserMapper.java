package namoo.springmvc.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import namoo.springmvc.dto.user.User;

@Repository
@Mapper
public interface UserMapper {
	
	/** 회원 등록 */
	public void create(User user);
	
	/** 회원 아이디로 회원 조회 */
	public User findById(String id);
	
	/** 회원 전체 목록 조회 */
	public  List<User> findAll();
	
	

}
