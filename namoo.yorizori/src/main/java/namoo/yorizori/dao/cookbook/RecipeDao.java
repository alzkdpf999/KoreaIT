package namoo.yorizori.dao.cookbook;

import java.sql.SQLException;
import java.util.List;

import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.cookbook.Recipe;

public interface RecipeDao {
	public void regist(Recipe recipe) throws SQLException;
	public  List<Recipe> view_All(int book_id) throws SQLException;
	
	public  List<Recipe> view_All() throws SQLException;
	public List<String> image(int recipe_id) throws SQLException;
	
	public Recipe detail(int recipe_id) throws SQLException;
	
	public String[] recipeId(String book_id) throws SQLException;
	
	public void modify(Recipe recipe) throws SQLException;
	
	public void delete(String recipe_id) throws SQLException;
	public void viewup(String recipe_id) throws SQLException;
	public void deleteCookbook(String book_id) throws SQLException;
	public List<Recipe> top4view() throws SQLException;
	
}

