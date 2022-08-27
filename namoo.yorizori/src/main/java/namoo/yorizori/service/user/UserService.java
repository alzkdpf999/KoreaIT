package namoo.yorizori.service.user;

import java.util.List;
import namoo.yorizori.common.web.Params;
import namoo.yorizori.dto.user.User;

/**
 * 사용자 관리 서비스
 * @author 김기정
 *
 */
public interface UserService {
	public void registerUser(User user);
	public User signIn(String id, String passwd);
	public User findById(String id);
	public List<User> findByAll(Params params);
	public int countUser(Params params);
}
