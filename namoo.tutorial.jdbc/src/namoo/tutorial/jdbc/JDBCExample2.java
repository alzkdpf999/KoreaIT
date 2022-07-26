package namoo.tutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCExample2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE"; //Oracle
		String user = "hr";
		String password = "hr";
		Connection conn=null;
		PreparedStatement pstmt = null;
		
			conn = DriverManager.getConnection(url,user,password);
			
			String sql= "INSERT INTO departments ( department_id,department_name)" +
					 "VALUES (departments_seq.NEXTVAL,?)";
			pstmt = conn.prepareStatement(sql);
			// ?를 넣으면 왠만하면 오류 안남
			pstmt.setString(1, "Korea IT"); //타입을 맞춰줌 0은 인자위치
			int cnt = pstmt.executeUpdate(); // sql 실행
		
				pstmt.close();
				conn.close();
			
		
	}

}
