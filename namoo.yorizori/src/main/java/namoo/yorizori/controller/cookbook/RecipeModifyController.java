package namoo.yorizori.controller.cookbook;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.dao.cookbook.ProcedureDao;
import namoo.yorizori.dto.cookbook.Procedure;
import namoo.yorizori.dto.cookbook.Recipe;

/**
 * Servlet implementation class RecipeModifyController
 */
@WebServlet("/recipe/modify.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 15)
public class RecipeModifyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("local", request.getHeader("referer"));
		String recipe_id = request.getParameter("recipeid");
		request.setAttribute("recipe", ServiceFactoryImpl.getInstance().getCookbookService().findRecipeById(Integer.parseInt(recipe_id)));
		request.setAttribute("proc_list", ServiceFactoryImpl.getInstance().getCookbookService().findProcedureByrecipeid(Integer.parseInt(recipe_id)));
		request.getRequestDispatcher("/WEB-INF/views/recipe/recipemodify.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProcedureDao procedureDao = jdbcDaoFactory.getInstance().getProcedureDao();
		HashMap<String,String> pcdMap = new HashMap<>();
		String[] procs = request.getParameterValues("seq_num"); //요리 절차 저장
		String[] nums = request.getParameterValues("num");
		String recipeName = request.getParameter("recipe_name");
		String recipe_time = request.getParameter("recipe_time");
		String recipe_level = request.getParameter("recipe_level");
		String ingredients = request.getParameter("ingredients");
		String book_id = request.getParameter("book_id");
		String imgFileName = request.getParameter("imgFileName");
		String contentType = request.getParameter("contentType");
		String recipeid = request.getParameter("recipeid");
		String delok = request.getParameter("imgdel");
		Part part = request.getPart("img_file_name");
		File file = new File("C:/Users/user/Desktop/KIT/img/");
		if (!file.exists()) {
			file.mkdirs();
		}
		if(!part.getSubmittedFileName().equals("")) {
			imgFileName = part.getSubmittedFileName();
			contentType = part.getContentType();
			part.write(file.getAbsolutePath() + File.separator + imgFileName);	
			
		}else{
			if(delok.equals("ok")) {
				imgFileName = "";
				contentType = "";
			}
		}	
		if(procs.length == nums.length) {
			for(int i=0; i<procs.length;i++) {
				pcdMap.put(nums[i], procs[i]);
			}
			ServiceFactoryImpl.getInstance().getCookbookService().modifyprocedure(pcdMap, recipeid);
		}else if(procs.length > nums.length) {
			for(int i =0; i < nums.length; i++) {
				pcdMap.put(nums[i], procs[i]);
			}
			for(int i = nums.length; i < procs.length;i++ ) {
				Procedure procdure = new Procedure();
				procdure.setRecipe_id(recipeid);
				procdure.setPcd(procs[i]);
				ServiceFactoryImpl.getInstance().getCookbookService().modifyinsertprocedure(procdure);
			}
			ServiceFactoryImpl.getInstance().getCookbookService().modifyprocedure(pcdMap, recipeid);
			
		}else {
			for(int i=0; i<procs.length; i++) {
				pcdMap.put(nums[i], procs[i]);
			}
			String[] delnum = Arrays.copyOfRange(nums, procs.length, nums.length);
			ServiceFactoryImpl.getInstance().getCookbookService().modifydel(delnum, recipeid);
			ServiceFactoryImpl.getInstance().getCookbookService().modifyprocedure(pcdMap, recipeid);
		}
		Recipe recipe = new Recipe();
		recipe.setRecipe_name(recipeName);
		recipe.setRecipe_level(Integer.parseInt(recipe_level));
		recipe.setRecipe_time(Integer.parseInt(recipe_time));
		recipe.setImg_cont_type(contentType);
		recipe.setImg_file_name(imgFileName);
		recipe.setIngredients(ingredients);
		recipe.setRecipe_id(Integer.parseInt(recipeid));
		ServiceFactoryImpl.getInstance().getCookbookService().modifyrecipe(recipe);
		response.sendRedirect(request.getContextPath()+"/recipe/list.do?cbid="+book_id);
	}

}
