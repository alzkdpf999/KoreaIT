package namoo.yorizori.dao.cookbook;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import namoo.yorizori.dto.cookbook.Recipe;

public class jdbcRecipeDao implements RecipeDao {
	private DataSource dataSource;
	public jdbcRecipeDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void regist(Recipe recipe) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Recipe> view_All() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
