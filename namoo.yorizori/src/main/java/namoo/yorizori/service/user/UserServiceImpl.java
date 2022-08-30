package namoo.yorizori.service.user;

import java.sql.SQLException;
import java.util.List;

import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.common.web.Params;
import namoo.yorizori.dao.user.UserDao;
import namoo.yorizori.dto.user.User;

public class UserServiceImpl implements UserService {
	UserDao userDao =  jdbcDaoFactory.getInstance().getUserDao();

	@Override
	public void registerUser(User user) {
		try {
			userDao.create(user);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public User signIn(String id, String passwd) {
		User user = null;
		try {
			 user = userDao.login(id, passwd);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return user;
	}

	@Override
	public User findById(String id) {
		User user = null;
		try {
			 user = userDao.read(id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return user;
	}

	@Override
	public List<User> findByAll(Params params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countUser(Params params) {
		// TODO Auto-generated method stub
		return 0;
	}

}
