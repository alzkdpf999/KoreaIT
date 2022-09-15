package namoo.yorizori.controller.cookbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.common.factory.jdbcDaoFactory;
import namoo.yorizori.common.web.YZRuntimeException;
import namoo.yorizori.dao.cookbook.RecipeDao;

/**
 * Servlet implementation class RecipeImageController
 */
@WebServlet("/recipe/image.do")
public class RecipeImageController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String recipeid = request.getParameter("recipeid");
		FileInputStream in = null;
		OutputStream out = null;
		List<String> list = ServiceFactoryImpl.getInstance().getCookbookService().findimageByrecipeid(Integer.parseInt(recipeid));
		String fileName = list.get(1);
		String contentType = list.get(0);
		if(fileName == null || contentType== null) {
			fileName="";
			contentType="";
		}
		if(contentType.equals("") || fileName.equals("")) {
			fileName = "cookbook-min.png";
			contentType="image/png";
		}
		response.setContentType(contentType);
		
		try {
			File file = new File("C:/Users/user/Desktop/KIT/img/" + fileName);
			in = new FileInputStream(file);
			out = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int count = 0;
			while((count=in.read(buffer)) != -1) {
				out.write(buffer, 0, count);			
			}
		} catch (Exception e) {
			throw new YZRuntimeException(e.getMessage());
		} finally {
			if(out != null) out.close();
			if(in != null) in.close();
		}
	}

}