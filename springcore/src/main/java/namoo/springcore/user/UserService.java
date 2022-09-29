package namoo.springcore.user;

import java.util.List;

/**
 * 회원관리 인터페이스(역할)
 * @author 정충효
 * 업무 이름과 비슷하게 하는게 좋음
 */
public interface UserService {
	public void registUser(User user);
	public User findUser(String id);
	public List<User> findUsers();
}
