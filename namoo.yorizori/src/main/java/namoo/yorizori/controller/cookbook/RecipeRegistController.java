package namoo.yorizori.controller.cookbook;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.dto.cookbook.Recipe;

/**
 * Servlet implementation class RecipeRegistController
 */
@WebServlet("/recipe/regist.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 15)
public class RecipeRegistController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getHeader("referer"));
		String recipeName = request.getParameter("recipe_name");
		String writer_id = request.getParameter("writer_id");
		String recipe_time = request.getParameter("recipe_time");
		String recipe_level = request.getParameter("recipe_level");
		String ingredients = request.getParameter("ingredients");
		Part part = request.getPart("img_file_name");
		String imgFileName = part.getSubmittedFileName();
		long fileSize = part.getSize();
		String contentType = part.getContentType();
		System.out.println(recipeName);
		System.out.println(imgFileName);
		System.out.println(fileSize);
		System.out.println(contentType);
		File file = new File("D:/koreaIt/img/");
		if (!file.exists()) {
			file.mkdirs();
		}

//		업로드 파일 저장
		part.write(file.getAbsolutePath() + File.separator + imgFileName);
		System.out.println("파일 저장 완료..");
		Recipe recipe = new Recipe();
		recipe.setRecipe_name(recipeName);
		recipe.setWriter_id(writer_id);
		recipe.setRecipe_level(Integer.parseInt(recipe_level));
		recipe.setRecipe_time(Integer.parseInt(recipe_time));
		recipe.setImg_cont_type(contentType);
		recipe.setImg_file_name(imgFileName);
		recipe.setIngredients(ingredients);
		try {
			jdbcDaoFactory.getInstance().getRecipeDao().regist(recipe);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath());

	}

}
