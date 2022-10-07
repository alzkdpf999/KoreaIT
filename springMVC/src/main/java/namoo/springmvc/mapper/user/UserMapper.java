package namoo.springmvc.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import namoo.springmvc.dto.user.User;
@Mapper
@Repository
public interface UserMapper {
	
	// 등록
	public void create(User user );
	
	//회원찾기
	public User findById(String id);
	
	//전체 회원 찾기
	public List<User> findAll();

}
