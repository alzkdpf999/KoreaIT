package namoo.common.factory;

import namoo.user.dao.UserDao;

/**
 * DaoFactory에 대한 규약을 선언하는 인터페이스 
 * @author 정충효
 *
 */
public interface DaoFactory {
	
	public UserDao getUserDao();
	
//	public BoardDao getBoardDao();
	
//	public xxxxDao getXXXDao();
}
