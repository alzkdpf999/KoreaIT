package namoo.tutorial.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * 메소드를 만들어서 사용
 * @author 정충효
 *
 */
public class JDBCExample3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
			/* 한줄로 가능
			 * ConnectionFactory conn= ConnectionFactory.getInstance();
			Connection con=conn.getConnection();
			*/
			Connection con=ConnectionFactory2.getInstance().getConnection();
			PreparedStatement pstmt = null;
			String sql= "INSERT INTO departments ( department_id,department_name)" +
					 "VALUES (departments_seq.NEXTVAL,?)";
			pstmt = con.prepareStatement(sql);
			// ?를 넣으면 왠만하면 오류 안남
			pstmt.setString(1, "Korea IT"); //타입을 맞춰줌 0은 인자위치
			int cnt = pstmt.executeUpdate(); // sql 실행
				pstmt.close();
				con.close();
			
		
	}

}
