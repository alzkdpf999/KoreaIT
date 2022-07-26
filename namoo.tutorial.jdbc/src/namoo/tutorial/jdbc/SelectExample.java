package namoo.tutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE"; //Oracle
		String user = "hr";
		String password = "hr";
		Connection conn=null;
		PreparedStatement pstmt = null;
		
			conn = DriverManager.getConnection(url,user,password);
			
			String sql= "select employee_id,last_name,salary,hire_date\r\n"
					+ "from employees";
			pstmt = conn.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery(); // sql 실행
			while(result.next()) {
				System.out.println("사원번호: "+ result.getInt("employee_id")+"이름: "+result.getString("last_name")+"급여: "+ result.getInt("salary")+"입사 일" +result.getDate("hire_date"));
				//인덱스를 인자로 하는 것은 비권장
				
			}
			result.close();
			pstmt.close();
			conn.close();
	}

}
