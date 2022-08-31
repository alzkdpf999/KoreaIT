package namoo.yorizori.dao.cookbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.cookbook.Recipe;

public class jdbcRecipeDao implements RecipeDao {
	private DataSource dataSource;

	public jdbcRecipeDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void regist(Recipe recipe) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		// +는 낭비가 심해서 StringBuilder를 이용한다.
		StringBuilder sb = new StringBuilder();
		sb.append(
				" INSERT INTO recipe(recipe_id, book_id, recipe_name, recipe_time, recipe_level, ingredients, img_cont_type, img_file_name, writer_id)")
				.append(" VALUES(recipe_seq.NEXTVAL,?,?,?,?,?,?,?,?)");

		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipe.getBook_id());
			pstmt.setString(2, recipe.getRecipe_name());
			pstmt.setInt(3, recipe.getRecipe_time());
			pstmt.setInt(4, recipe.getRecipe_level());
			pstmt.setString(5, recipe.getIngredients());
			pstmt.setString(6, recipe.getImg_cont_type());
			pstmt.setString(7, recipe.getImg_file_name());
			pstmt.setString(8, recipe.getWriter_id());
			pstmt.executeUpdate(); // sql 실행

		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
	}

	@Override
	public List<Recipe> view_All(int book_id) throws SQLException {
		List<Recipe> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT recipe_id, book_id, recipe_name, recipe_time, recipe_level, ingredients, img_cont_type, img_file_name, writer_id, view_num")
				.append(" FROM recipe").append(" WHERE book_id = ?")
				.append(" ORDER BY recipe_id");

		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, book_id);
			result = pstmt.executeQuery();
			list = new ArrayList<Recipe>();
			while (result.next()) {
				Recipe recipe = createRecipe(result);
				list.add(recipe);
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

	private Recipe createRecipe(ResultSet result) throws SQLException {
		Recipe recipe = new Recipe();
		recipe.setRecipe_id(result.getInt("recipe_id"));
		recipe.setBook_id(result.getInt("book_id"));
		recipe.setRecipe_name(result.getString("recipe_name"));
		recipe.setRecipe_time(result.getInt("recipe_time"));
		recipe.setRecipe_level(result.getInt("recipe_level"));
		recipe.setIngredients(result.getString("ingredients"));
		recipe.setImg_cont_type(result.getString("img_cont_type"));
		recipe.setImg_file_name(result.getString("img_file_name"));
		recipe.setWriter_id(result.getString("writer_id"));
		recipe.setView_num(result.getInt("view_num"));
		return recipe;
	}

	@Override
	public Recipe image(int recipe_id) throws SQLException {
		Recipe recipe = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT img_cont_type, img_file_name")
		.append(" FROM recipe").append(" WHERE recipe_id = ?")
		.append(" ORDER BY recipe_id");
		try {
			con = dataSource.getConnection();
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipe_id);
			result = pstmt.executeQuery();
			if (result.next()) {
				recipe = createRecipe(result);
			}
		} finally {
			if (result != null)
				result.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close(); // 예외 저대로 안발생
		}
		return recipe;
	}
}
