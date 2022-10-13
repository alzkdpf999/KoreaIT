package namoo.springJPA.service.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import namoo.springJPA.entity.user.User;
import namoo.springJPA.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userMapper;

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

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	/*public void updateUser(Map<String, Object> map) {
		userMapper.update(map);
		
	}*/
	
	
}
