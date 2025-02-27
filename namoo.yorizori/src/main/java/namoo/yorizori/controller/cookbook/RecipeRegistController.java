package namoo.yorizori.controller.cookbook;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.dto.cookbook.Procedure;
import namoo.yorizori.dto.cookbook.Recipe;

/**
 * Servlet implementation class RecipeRegistController
 */
@WebServlet(urlPatterns={"/recipe/regist.do","/recipe/my/regist.do","/recipe/myrecipe/regist.do","/recipe/main/regist.do"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 15)
public class RecipeRegistController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("local", request.getHeader("referer"));
		request.getRequestDispatcher("/WEB-INF/views/recipe/recipeForm.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String imgFileName =null;
		String contentType =null;
		String[] procs = request.getParameterValues("seq_num"); //요리 절차 저장
		String recipeName = request.getParameter("recipe_name");
		String writer_id = request.getParameter("writer_id");
		String recipe_time = request.getParameter("recipe_time");
		String book_id = request.getParameter("book_id");
		String recipe_level = request.getParameter("recipe_level");
		String ingredients = request.getParameter("ingredients");
		String local = request.getParameter("local");
		Part part = request.getPart("img_file_name");
		File file = new File("C:/Users/user/Desktop/KIT/img/");
		if (!file.exists()) {
			file.mkdirs();
		}
//		업로드 파일 저장
		if(!part.getSubmittedFileName().equals("")) {
			imgFileName = part.getSubmittedFileName();
			contentType = part.getContentType();
			part.write(file.getAbsolutePath() + File.separator + imgFileName);	
		}else {
			imgFileName = "";
			contentType = "";
		}
		
		Recipe recipe = new Recipe();
		recipe.setBook_id(Integer.parseInt(book_id));
		recipe.setRecipe_name(recipeName);
		recipe.setWriter_id(writer_id);
		recipe.setRecipe_level(Integer.parseInt(recipe_level));
		recipe.setRecipe_time(Integer.parseInt(recipe_time));
		recipe.setImg_cont_type(contentType);
		recipe.setImg_file_name(imgFileName);
		recipe.setIngredients(ingredients);
		
		ServiceFactoryImpl.getInstance().getCookbookService().registerRecipe(recipe);
		for(String proc : procs) {
			Procedure procdure = new Procedure();
			procdure.setPcd(proc);
			ServiceFactoryImpl.getInstance().getCookbookService().registerProcedure(procdure);
		}
		response.sendRedirect(local);
		//response.sendRedirect(request.getContextPath()+"/recipe/list.do?cbid="+book_id);

	}
}

