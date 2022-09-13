package namoo.yorizori.dao.cookbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		sb.append(" INSERT INTO cookbook(book_id,book_name,book_desc,author_id, author_name)")
		  .append(" VALUES(cookbook_seq.NEXTVAL,?,?,?,?)");
		
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cookbook.getBook_name());
			pstmt.setString(2, cookbook.getBook_desc());
			pstmt.setString(3, cookbook.getAuthor_id());
			pstmt.setString(4, cookbook.getAuthor_name());
			pstmt.executeUpdate(); // sql 실행

		}
		finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
	}
	public  List<Cookbook> view_All() throws SQLException{
		List<Cookbook> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" Select book_id,book_name,book_desc,author_id,view_num,author_name")
				.append(" from cookbook")
				.append(" WHERE exist =1")
				.append(" ORDER BY book_id");
		
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeQuery();
			list = new ArrayList<Cookbook>();
			while(result.next()) {
				Cookbook book = createbook(result);
				list.add(book);
			}
		} finally {
			if (result != null)
				result.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return list;
	}
	
	
	private Cookbook createbook(ResultSet result) throws SQLException {
		Cookbook book = new Cookbook();
		book.setBook_id(result.getString("book_id"));
		book.setBook_name(result.getString("book_name"));
		book.setBook_desc(result.getString("book_desc"));
		book.setAuthor_id(result.getString("author_id"));
		book.setAuthor_name(result.getString("author_name"));
		book.setView_num(result.getString("view_num"));
		return book;
	}
	public  Cookbook view_All(String book_id) throws SQLException{
		Cookbook cookbook = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" Select book_id,book_name,book_desc,author_id,view_num,author_name")
				.append(" from cookbook")
				.append(" WHERE book_id = ? and exist = 1")
				.append(" ORDER BY book_id");
		
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,book_id);
			result = pstmt.executeQuery();
			if(result.next()) {
				cookbook = createbook(result);
			}
		} finally {
			if (result != null)
				result.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return cookbook;
	}
	public void modify(Cookbook cookbook) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE cookbook set book_desc = ? ,book_name =?")
		  .append(" WHERE book_id = ? and exist = 1");
		
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cookbook.getBook_desc());
			pstmt.setString(2, cookbook.getBook_name());
			pstmt.setString(3, cookbook.getBook_id());
			pstmt.executeUpdate(); // sql 실행

		}
		finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
	}
	@Override
	public void delete(String book_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE cookbook set exist = 0")
				.append(" where book_id =? and exist = 1");

		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book_id);
			
			pstmt.executeUpdate(); // sql 실행

		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
	}
	@Override
	public void viewup(String book_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE cookbook set view_num = view_num+1")
				.append(" where book_id =? and exist = 1");

		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book_id);
			
			pstmt.executeUpdate(); // sql 실행

		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		
	}
	@Override
	public List<Cookbook> top4view() throws SQLException {
		List<Cookbook> list = null;
		Cookbook book =null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" select book_id, book_name,author_name,author_id")
				.append(" from (select book_id,book_name,author_name,author_id,exist from cookbook order by view_num desc) A")
				.append(" where rownum <=4 and exist =1");
		
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeQuery();
			list = new ArrayList<Cookbook>();
			while(result.next()) {
				book = new Cookbook();
				book.setBook_id(result.getString("book_id"));
				book.setBook_name(result.getString("book_name"));
				book.setAuthor_id(result.getString("author_id"));
				book.setAuthor_name(result.getString("author_name"));
				list.add(book);
			}
		} finally {
			if (result != null)
				result.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return list;
	}
	@Override
	public List<Cookbook> view_mybook(String author_id) throws SQLException {
		List<Cookbook> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" Select book_id,book_name,book_desc,author_id,view_num,author_name")
				.append(" from cookbook")
				.append(" WHERE exist =1 and author_id = ?")
				.append(" ORDER BY book_id");
		
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, author_id);
			result = pstmt.executeQuery();
			list = new ArrayList<Cookbook>();
			while(result.next()) {
				Cookbook book = createbook(result);
				list.add(book);
			}
		} finally {
			if (result != null)
				result.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return list;
	}
	
}







