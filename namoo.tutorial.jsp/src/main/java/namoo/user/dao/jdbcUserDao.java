package namoo.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import namoo.user.dto.User;

//기술 이름을 앞에 붙여서 하는것이 좋음
public class jdbcUserDao implements UserDao {

	private DataSource dataSource;

	public jdbcUserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(User user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO users(id,passwd,name,email)").append(" VALUES (?,?,?,?)");
		try {
			con = dataSource.getConnection();
//			con.setAutoCommit(true); 자동적으로 되어잇음
//			con.setAutoCommit(false); 개발자가 트랜젝션 직업 실행할때
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId()); // 타입을 맞춰줌 0은 인자위치
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.executeUpdate(); // sql 실행

//			pstmt = con.prepareStatement("update....");
//			pstmt.executeUpdate();
//			con.commit();
		}
//		catch(SQLException e){
//			con.rollback(); //롤백도 try catch해줘야 한다.
//		}
		finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
	}

	public User read(String id) throws SQLException {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" Select id, passwd, name, email, TO_CHAR(regdate,'YYYY-MM-DD DAY') AS regdate").append(" from users")
				.append(" where id = ?");
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			if (result.next()) {
				user = new User();
				user.setId(result.getString("id"));
				user.setPasswd(result.getString("passwd"));
				user.setName(result.getString("name"));
				user.setEmail(result.getString("email"));
				user.setRegdate(result.getString("regdate"));
			}
		} finally {
			if (result != null)
				result.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return user;
	}

	public User login(String id, String passwd) throws SQLException {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id,passwd,name,email,TO_CHAR(regdate,'YYYY-MM-DD DAY') regdate").append(" FROM users")
				.append(" WHERE id = ? AND passwd=?");
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			result = pstmt.executeQuery();
			if (result.next()) {
				user = new User();
				user.setId(result.getString("id"));
				user.setPasswd(result.getString("passwd"));
				user.setName(result.getString("name"));
				user.setEmail(result.getString("email"));
				user.setRegdate(result.getString("regdate"));
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return user;
	}

	public List<User> list() throws SQLException {
		List<User> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		// *로 하면 성능이 확 떨어짐
		sb.append(" SELECT id,passwd,name,email,TO_CHAR(regdate,'YYYY-MM-DD DAY') regdate").append(" FROM users");
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeQuery();
			list = new ArrayList<User>();
			while (result.next()) {
				User user = createUser(result);
				list.add(user);
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return list;

	}

	// 페이지별로 출력
	@Override
	public List<User> listByPage(int page) throws SQLException {
		List<User> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, passwd, email, regdate")
				.append(" FROM ( SELECT CEIL(rownum / 10) request_page, id, name, passwd, email, regdate")
				.append("  FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate")
				.append("   FROM users").append("   ORDER  BY regdate DESC))").append("   WHERE  request_page = ?");
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, page);
			result = pstmt.executeQuery();
			list = new ArrayList<User>();
			while (result.next()) {
				User user = createUser(result);
				list.add(user);
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return list;
	}

	private User createUser(ResultSet result) throws SQLException {
		User user = new User();
		user.setId(result.getString("id"));
		user.setPasswd(result.getString("passwd"));
		user.setName(result.getString("name"));
		user.setEmail(result.getString("email"));
		user.setRegdate(result.getString("regdate"));
		return user;
	}

	// 선택페이지, 조회 목록개수에 따른 사용자 목록 반환
	@Override
	public List<User> listByPage(int page, int listSize) throws SQLException {
		List<User> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, passwd, email, regdate")
				.append(" FROM ( SELECT CEIL(rownum / ?) request_page, id, name, passwd, email, regdate")
				.append("  FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate")
				.append("   FROM users").append("   ORDER  BY regdate DESC))").append("   WHERE  request_page = ?");
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, listSize);
			pstmt.setInt(2, page);
			result = pstmt.executeQuery();
			list = new ArrayList<User>();
			while (result.next()) {
				User user = createUser(result);
				list.add(user);
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return list;
	}

	@Override
	public List<User> listByPage(int page, int listSize, String searchType, String searchValue) throws SQLException {
		List<User> list = null;
		StringBuilder Type = new StringBuilder();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		
		if (searchType.equals("id")) {
			Type.append(" WHERE id =")
			.append(searchValue);
		} else {
			searchValue = "%"+searchValue+"%";
			Type.append(" WHERE name like")
				.append(searchValue);
		}
		sb.append(" SELECT id, name, passwd, email, regdate")
		  .append(" FROM ( SELECT CEIL(rownum / ?) request_page, id, name, passwd, email, regdate")
		  .append("        FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate")
		  .append("                 FROM users")
		  .append(Type)
		  .append("                 ORDER  BY regdate DESC))")
		  .append(" WHERE  request_page = ?");
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, listSize);
			pstmt.setInt(2, page);
			result = pstmt.executeQuery();
			list = new ArrayList<User>();
			while (result.next()) {
				User user = createUser(result);
				list.add(user);
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return list;
	}

	@Override
	public int countByPage(String searchType, String searchValue) throws SQLException {
		List<User> list = null;
		StringBuilder Type = new StringBuilder();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		int cnt = 0; 
		if (searchType == null && searchValue == null) {
			list = list();
			sb.append(" SELECT COUNT(id) count")
			  .append(" FROM   users");

		}else {
			if(searchType.equals("id")) {
				Type.append(" WHERE id =")
					.append(searchValue);
			}else {
				searchValue = "%"+searchValue+"%";
				Type.append(" WHERE name like")
					.append(searchValue);
				
			}
			sb.append(" SELECT COUNT(id) count")
			  .append(" FROM   users")
			  .append(  Type);			
		}	
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeQuery();
			list = new ArrayList<User>();
			if(result.next()) {
				cnt = result.getInt(1);
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return cnt;
	}
}
