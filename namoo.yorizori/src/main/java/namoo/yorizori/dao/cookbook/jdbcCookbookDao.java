package namoo.yorizori.dao.cookbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import namoo.yorizori.dto.cookbook.Cookbook;

public class jdbcCookbookDao implements CookbookDao{
	private DataSource dataSource;

	public jdbcCookbookDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void regist(Cookbook cookbook) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO cookbook(book_id,book_name,book_desc,author_id)")
		  .append(" VALUES(?,?,?,?)");
		
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cookbook.getBook_id()); // 타입을 맞춰줌 0은 인자위치
			pstmt.setString(2, cookbook.getBook_name());
			pstmt.setString(3, cookbook.getBook_desc());
			pstmt.setString(4, cookbook.getAuthor_id());
			pstmt.executeUpdate(); // sql 실행

		}
		finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
	}
}






