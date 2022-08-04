package namoo.user.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import namoo.common.factory.jdbcDaoFactory;
import namoo.user.dto.User;
/**
 * 서버에서 동작하는 비즈니스 객체라 가정
 * @author 정충효
 *
 */
public class DaoTest {

	public static void main(String[] args) throws SQLException {
//		DataSource dataSource = ConnectionFactory3.getInstance().getDataSource();
//		UserDao userDao = new jdbcUserDao(dataSource);
//		UserDao userDao = new MybatisUserDao(dataSource);
		
//		
		UserDao userDao=jdbcDaoFactory.getInstance().getUserDao();
		
		User user =new User("test","12345","Jack","qacqwk@naver.com");
		try {
			userDao.create(user);
//			System.out.println("정상 가입 완료");
//			User user = userDao.read("bangry");
//			if(user!=null) {
//				System.out.println(user.getId()+","+user.getName());
//			}else {
//				System.out.println("존재X");
//			}
//		List<User> list =userDao.list();
//		Iterator<User> iter=list.iterator();
//		while(iter.hasNext()) {
//			User user = iter.next();
//			System.out.println(user.toString());
//		}
		} catch (SQLException e) {
			System.out.println("회원가입 처리중 예외 발생"+e);
			
			
		}
		
	}

}
