package namoo.yorizori.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import namoo.yorizori.common.web.Params;
import namoo.yorizori.dto.user.User;
//기술 이름을 앞에 붙여서 하는것이 좋음
public class MybatisUserDao implements UserDao {

	private DataSource dataSource;

	public MybatisUserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(User user) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt = null;
		//+는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb =new StringBuilder();
		sb.append("INSERT INTO users(id,passwd,name,email)")
		  .append("VALUES (?,?,?,?)");
		try {
			con = dataSource.getConnection();
			String sql= sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId()); //타입을 맞춰줌 0은 인자위치
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.executeUpdate(); // sql 실행
		}finally {
			if(pstmt!=null)	pstmt.close();
			if(con!=null)	con.close(); //예외 저대로 안발생
		}
	}

	public User read(String id) throws SQLException {
		return null;
	}

	public User login(String id, String passwd) throws SQLException {
		return null;
	}
	public List<User> list() throws SQLException{
		return null;
	}

	@Override
	public int loginResult(String id, String passwd) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> listByPage(Params params) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByPage(Params params) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


	/*
	 * public List<User> listByPage(Params params) throws SQLException { return
	 * listByPage(params.getPage(), params.getSearchList(), params.getSearchType(),
	 * params.getSearchValue()); }
	 * 
	 * @Override public int countByPage(Params params) throws SQLException { return
	 * countByPage(params.getSearchType(), params.getSearchValue()); }
	 */
}
