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
import namoo.yorizori.dao.cookbook.RecipeDao;

/**
 * Servlet implementation class RecipeImageController
 */
@WebServlet("/cookbook/image.do")
public class CookbookImageController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		recipe  테이블에서 파일이름과 컨텐츠 타입 읽어오기
		String[] image = new String[2];
		String book_id = request.getParameter("book_id");
		FileInputStream in = null;
		OutputStream out = null;
		
		image = ServiceFactoryImpl.getInstance().getCookbookService().findCookimage(book_id);
		if( image[0] ==null|| image[1]== null) {
			image[0] ="";
			image[1] = "";
		}
		String contentType = image[0];
		String fileName = image[1];
		if (contentType.equals("") || fileName.equals("")) {
			fileName = "cookbook-min.png";
			contentType = "image/png";
		}
		response.setContentType(contentType);

		try {
			File file = new File("C:/Users/user/Desktop/KIT/img/" + fileName);
			in = new FileInputStream(file);
			out = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
		} finally {
			if (out != null)
				out.close();
			if (in != null)
				in.close();
		}
	}

}