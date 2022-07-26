package namoo.tutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCExample {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//오라클 드라이버 로드 & DriverManager에 오라클 드라이버 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로딩 완료");	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Oracle 연결
		String url = "jdbc:oracle:thin:@localhost:1521:XE"; //Oracle
		String user = "hr";
		String password = "hr";
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url,user,password);
			
			System.out.println("오라클 서버와 정상 연결됨...");
			System.out.println(conn);
			String sql= "INSERT INTO departments ( department_id,department_name)" +
					 "VALUES (departments_seq.NEXTVAL,?)";
			pstmt = conn.prepareStatement(sql);
			System.out.println(pstmt);
			// ?를 넣으면 왠만하면 오류 안남
			pstmt.setString(1, "Korea IT"); //타입을 맞춰줌 0은 인자위치
			int cnt = pstmt.executeUpdate(); // sql 실행
			System.out.println(cnt+"행이 추가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
