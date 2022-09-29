package namoo.springcore.user;

import java.util.List;

public interface UserRepository {

	public void create(User user) ;
	public User findById(String id) ;
	public List<User> findByAll();
	
}	
