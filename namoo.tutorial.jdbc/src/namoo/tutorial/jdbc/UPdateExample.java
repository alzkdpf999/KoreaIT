package namoo.tutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UPdateExample {
	//메소드화
	public static int UpdateDepartmentsName(int departmentId, String departmentName) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE"; //Oracle
		String user = "hr";
		String password = "hr";
		Connection conn=null;
		PreparedStatement pstmt = null;
		
			conn = DriverManager.getConnection(url,user,password);
			String sql= "update departments\r\n"
					+ "    SET department_name = ?\r\n"
					+ "where department_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,departmentName);
			pstmt.setInt(2,departmentId);
			
			int cnt =pstmt.executeUpdate();			
			return cnt;
			
	}
// 먼저 sqldevelope에서 먼저 한 다음 sql에 넣는것이 좋음
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		int cnt = UpdateDepartmentsName(300,"대통령실");
		System.out.println(cnt+"행이 수정되었습니다.");
		
	}

}
