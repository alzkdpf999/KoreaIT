package namoo.tutorial.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		System.out.println("Writer : " + writer);
		String file = request.getParameter("upfile1");
		System.out.println("File : " + file);
		// 서블릿 API를 이용하여 업로드 파일 데이터 읽기
		InputStream in = request.getInputStream();
		byte[] buffer = new byte[1024];
		int count = 0;
		while((count=in.read(buffer)) != -1){
		String data = new String(buffer, 0, count);
		System.out.println(data);
		}
		in.close();
	}

}
