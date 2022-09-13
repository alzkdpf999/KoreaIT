package namoo.yorizori.dao.cookbook;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import namoo.yorizori.dto.cookbook.Procedure;

public interface ProcedureDao {
	public void regist(Procedure procedure) throws SQLException;
	public List<Procedure> show(int recipe_id)throws SQLException;
	public void modify(HashMap<String, String> pcdMap, String recipeid) throws SQLException;
	public void modifyregist(Procedure procedure) throws SQLException;
	public void modifydel(String[] num,String recipeid) throws SQLException;
}
