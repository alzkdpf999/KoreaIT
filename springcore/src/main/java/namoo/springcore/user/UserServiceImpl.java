package namoo.springcore.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//@Component
@Service
//@Scope("prototype") 왠만하면 안고침
public class UserServiceImpl implements UserService {
	//private UserRepository userRepository = new MemoryUserRepository(); 아래와 같은 방식으로
	//필드 Autowired는 변경이 안됌 그래서 생성자에 넣음
	//@Autowired 
	private UserRepository userRepository;
	
	//DI방식 의존관계 주입을 위한 생성자
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	
	@Override
	public void registUser(User user) {
		userRepository.create(user);
	}

	@Override
	public User findUser(String id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findUsers() {
		return userRepository.findByAll();
	}

}
