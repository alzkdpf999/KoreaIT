package namoo.tutorial.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 자료실 목록 조회
 */
public class FileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fileStorage;

	public void init() throws ServletException {
		fileStorage = getServletContext().getInitParameter("fileStorage");
		
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File directory = new File(fileStorage);
		File[] fileList = directory.listFiles();//파일 목록 읽기
		for (File file : fileList) {
			String fileName = file.getName();
			long filesize = file.length();
			System.out.println(fileName +": "+ filesize);
		}
	}

}
