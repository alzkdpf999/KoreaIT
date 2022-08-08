package namoo.tutorial.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileUploadServlet2 extends HttpServlet {
	//String fileStorage = “d:/.../...”;
	private String fileStorage;
	private int limitFileSize = 2 * 1024 * 1024;
	@Override
	public void init() throws ServletException {
		fileStorage = getServletContext().getInitParameter("fileStorage");
		String size = getServletContext().getInitParameter("limitFileSize");
		if( size != null){
			limitFileSize = Integer.parseInt(size);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		//			Apache 제공 파일 업로드 API 사용법
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// FileUpload API 활용
		File storageDir = new File(fileStorage);
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		// 파일 저장 위치
		fileItemFactory.setRepository(storageDir);
		// 파일 사이즈 제한 만약 아래것을 없애면 무제한이지만 심각한 오류를 발생할 수 있음
		fileItemFactory.setSizeThreshold(limitFileSize);
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					System.out.println("파라메터 이름 : " + item.getFieldName());
					System.out.println("파라메터 값 : " + item.getString("utf-8"));
				}else {
					System.out.println("파라메터 이름 : " + item.getFieldName());
					System.out.println("파일명 : " + item.getName());
					System.out.println("파일사이즈 : " + item.getSize());
					if(item.getSize() > 0){
						String separator = File.separator;
						int index = item.getName().lastIndexOf(separator);//긴 파일에서 순수파일 이름을 가지고온다
						String fileName = item.getName().substring(index + 1); // 순수파일 이름을 넣어둔다.
						File uploadFile = new File(fileStorage + File.separator + fileName);
						item.write(uploadFile);
					}
				}
			}
			out.println("<html>");
			out.println("<body>");
			out.println("<h2>파일 업로드 완료!</h2>");
			out.println("</body>");
			out.println("</html>");
			//response.sendRedirect("/파일목록처리 서블릿");
		} catch (Exception e) {
			e.printStackTrace();
			new ServletException(e.getMessage());
		}
	}
}



