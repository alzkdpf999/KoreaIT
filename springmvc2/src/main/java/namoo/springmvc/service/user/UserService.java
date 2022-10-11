package namoo.springmvc.service.user;

import java.util.List;

import namoo.springmvc.dto.user.User;

/**
 * 회원 관리 인터페이스 (역할)
 * @author 김기정
 *
 */
public interface UserService {
	
	public void registUser(User user);
	public User findUser(String id);
	public List<User> findUsers();

}
