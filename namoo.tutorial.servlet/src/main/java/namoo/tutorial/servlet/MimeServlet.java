package namoo.tutorial.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MimeServlet extends HttpServlet {
	//String path ="D:/Lecture/강의자료/Servlet.pdf";
	String path = "D:/Lecture/강의자료/sample.mp3";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	response.setContentType("application/pdf");//pdf 
//	response.setContentType("audio/mpeg"); 음악 재생
	response.setContentType("application/octet-stream");//다운로드
	OutputStream out = response.getOutputStream();
	InputStream in = new FileInputStream(path);		
	byte[] buffer = new byte[1024];
	int count = 0;
	while((count=in.read(buffer)) != -1){
		out.write(buffer,0,count);
	}
	out.close();
	in.close();
	}

}
