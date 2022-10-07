package namoo.springmvc.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import namoo.springmvc.dto.user.User;
import namoo.springmvc.mapper.user.UserMapper;

@Service
public class UserServiceImpl implements UserService {
 
	@Autowired
	private UserMapper userMapper;
	
	@Override // 유저등록
	public void registUser(User user) {
	}

	@Override // 유저 찾기
	public User findUser(String id) {
		return null;
	}

	@Override // 전체 유저
	public List<User> findUsers() {
		return userMapper.findAll();
	}

}
