package namoo.springmvc.service.user;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import namoo.springmvc.dto.user.User;
import namoo.springmvc.mapper.user.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void registUser(User user) {
		userMapper.create(user);
	}

	@Override
	public User findUser(String id) {
		return userMapper.findById(id);
	}

	@Override
	public List<User> findUsers() {
		return userMapper.findAll();
	}

}
