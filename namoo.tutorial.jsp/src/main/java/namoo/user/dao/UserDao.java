package namoo.user.dao;

import java.sql.SQLException;
import java.util.List;

import namoo.common.web.Params;
import namoo.user.dto.User;

/**
 * DAO 객체는 영속적 데이터 처리를 위한 다양한 기술(JDBC,JPA,iBatis,Hibernate 등)들을
 * 일관된 방법(메소드 호출)으로 접근할 수 있도록 규약 메소드 선언
 * @author 정충효
 *
 */
public interface UserDao {
	/**
	 *회원가입 
	 * @param user
	 * @throws SQLException
	 */
	public void create(User user) throws SQLException;//객체 단위로 받기 User라는 객체
	/** 사용자 id에 해당하는 정보반환 */
	public User read(String id) throws SQLException;
	/** 사용자 로그인*/
//	public boolean login(String id,String passwd) throws SQLException;
	/** 사용자 데이터를 좀 더 유용하게 쓸 수 있음*/
	public User login(String id,String passwd) throws SQLException;
	/**사용자 전체 목록 반환*/
	public List<User> list() throws SQLException;
	
//	public List<User> list(String type, String value) throws SQLException;
	/**선택페이지의 따른 목록 반환**/
	public List<User> listByPage(int page) throws SQLException;
	
	//목록 수의 따른 변화
	public List<User> listByPage(int page, int listSize) throws SQLException;
	// 검색 타입에 따른 변화
	public List<User> listByPage(int page, int listSize,String searchType, String searchValue) throws SQLException;
	
	//검색 타입과 전체에서의 총 인원 수
	public int countByPage(String searchType, String searchValue) throws SQLException;
	
	/** Params(선택페이지, 조회 목록개수, 검색유형, 검색값)에 따른 사용자 목록 반환 */	
	public List<User> listByPage(Params params) throws SQLException;
	
	/** Params(검색유형, 검색값에 따른 사용자 개수 반환 - 페이징 처리 시 필요 */
	public int countByPage(Params params) throws SQLException;
}	
