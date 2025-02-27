package namoo.springcore.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MemoryUserRepository implements UserRepository {
	private Map<String, User> map = new HashMap<String, User>();

	@Override
	public void create(User user) {
		map.put(user.getId(), user);
	}

	@Override
	public User findById(String id) {
//		return map.get(id);
		return new User("1","2","3","4");
	}

	@Override
	public List<User> findByAll() {
		List<User> list =new ArrayList<User>();
		Collection<User> col = map.values();
		Iterator<User> it = col.iterator();
		while (it.hasNext()) {
			User user = it.next();
			list.add(user);
		}
		return list;
	}

}