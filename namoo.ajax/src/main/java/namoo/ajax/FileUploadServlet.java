package namoo.ajax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class RecipeRegistController
 */
@WebServlet("/upload.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 15)
public class FileUploadServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Part infile = request.getPart("infile");
		
		File file = new File("D:/koreaIt/img/");
		String comments = request.getParameter("commnets");
		System.out.println(infile.getSubmittedFileName());
		System.out.println(infile.getSize());
		if (!file.exists()) {
			file.mkdirs();
		}
		infile.write(file.getAbsolutePath() + File.separator + infile.getSubmittedFileName());
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out  =response.getWriter();
		out.print("파일 정상 업로드 처리 ");
	}
}
