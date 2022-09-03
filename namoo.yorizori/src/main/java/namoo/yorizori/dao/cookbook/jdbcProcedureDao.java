package namoo.yorizori.dao.cookbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import namoo.yorizori.dto.cookbook.Procedure;
import namoo.yorizori.dto.cookbook.Recipe;

public class jdbcProcedureDao implements ProcedureDao {
	private DataSource dataSource;

	public jdbcProcedureDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void regist(Procedure procedure) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO recipe_procedure(recipe_id, seq_num, procedure)")
		  .append(" values(?,cookseq_seq.NEXTVAL,?)");
		
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, procedure.getRecipe_id());
			pstmt.setString(2, procedure.getPcd());
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
	public List<Procedure> show(int recipe_id) throws SQLException {
		List<Procedure> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT recipe_id, seq_num, procedure")
				.append(" FROM recipe_procedure").append(" WHERE recipe_id = ?")
				.append(" ORDER BY recipe_id, seq_num");

		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipe_id);
			result = pstmt.executeQuery();
			list = new ArrayList<Procedure>();
			while (result.next()) {
				Procedure porcedure = createProcedure(result);
				list.add(porcedure);
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
	public Procedure createProcedure(ResultSet result) throws SQLException{
		Procedure procedure = new Procedure();
		procedure.setRecipe_id(result.getString("recipe_id"));
		procedure.setSeq_num(result.getInt("seq_num"));
		procedure.setPcd(result.getString("pcd"));
		return procedure;
	}
}
