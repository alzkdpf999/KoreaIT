package namoo.yorizori.controller.cookbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.common.web.YZRuntimeException;
import namoo.yorizori.dao.cookbook.RecipeDao;
import namoo.yorizori.dto.cookbook.Recipe;

/**
 * Servlet implementation class RecipeImageController
 */
@WebServlet("/recipe/image.do")
public class RecipeImageController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String recipeId = request.getParameter("recipeid");
//		recipe  테이블에서 파일이름과 컨텐츠 타입 읽어오기
		
		RecipeDao recipeDao = jdbcDaoFactory.getInstance().getRecipeDao();
		

		FileInputStream in = null;
		OutputStream out = null;
		// 주소 변경해줘야 함
		try {
			Recipe recipe = recipeDao.image(Integer.parseInt(recipeId));
			String fileName = recipe.getImg_file_name();
			String contentType = recipe.getImg_cont_type();
			response.setContentType(contentType);
			File file = new File("D:/koreaIt/img/" + fileName);
			in = new FileInputStream(file);
			out = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		} finally {
			if (out != null)
				out.close();
			if (in != null)
				in.close();
		}
	}

}
