package namoo.tutorial.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

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
//		process(request, response);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		File directory = new File(fileStorage);
		File[] fileList = directory.listFiles();//파일 목록 읽기
		out.print("<!DOCTYPE HTML>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"utf-8\">");
		out.print("<title>가입 인원</title>");
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/table.css\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<br>");

		out.print("<table>");
		out.print("<caption>무료 자료실</caption>");
		out.print("<thead>");
		out.print("<tr>");
		out.print("<th id=\"fn\" scope=\"col\">순번</th>");
		out.print("<th id=\"fr\" scope=\"col\">파일 이름</th>");
		out.print("<th id=\"to\" scope=\"col\">파일 사이즈</th>");
		out.print("</tr>");
		out.print("</thead>");
		out.print("<tfoot>");
		out.print("<tr>");
		out.print("</tr>");
		out.print("</tfoot>");
		out.print("<tbody>");

		for (File file1 : fileList) {
			int i=1;
			String fileName1 = file1.getName();
			long filesize = file1.length();
			System.out.println(fileName1 +": "+ filesize);
			out.print("<tr>");
			out.print("<td>"+i+"</td>");
			out.print("<td><a href ='download.do?file="+fileName1+"'>"+fileName1+"</a></td>");
			out.print("<td>"+filesize+"</td>");
			out.print("</tr>");
			i++;
		}
		out.print("</tbody>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}
	/*
	 * public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

		String fileName = request.getParameter("file");
		if (fileName == null || fileName.equals(""))
			return;
		String filePath = fileStorage + File.separator + fileName;
		File file = new File(filePath);
		// HTTP 버전별 브라우저 캐시 사용 않도록 응답헤더 설정 
		String httpVersion = request.getProtocol();
		if (httpVersion.equals("HTTP/1.0")) {
			response.setDateHeader("Expires", 0);
			response.setHeader("Pragma", "no-cache");
		} else if (httpVersion.equals("HTTP/1.1")) {
			response.setHeader("Cache-Control", "no-cache");
		}
		// 파일 다운로드 처리를 위한 응답헤더에 마임타입 설정
		response.setContentType("application/octet-stream");
		fileName = URLEncoder.encode(fileName, "utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
		response.setHeader("content-Length",file.length()+ "");//문자열로 바꿔줘야한다.
		FileInputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		try{
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
		}finally{
			if(out != null) out.close();
			if(in != null) in.close();
		}
	}
*/
}
