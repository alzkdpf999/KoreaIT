package namoo.yorizori.dao.cookbook;

import java.sql.SQLException;
import java.util.List;

import namoo.yorizori.dto.cookbook.Procedure;

public interface ProcedureDao {
	public void regist(Procedure procedure) throws SQLException;
	public List<Procedure> show(int recipe_id)throws SQLException;
}
