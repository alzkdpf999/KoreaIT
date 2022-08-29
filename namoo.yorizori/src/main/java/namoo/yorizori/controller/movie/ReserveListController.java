package namoo.yorizori.controller.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.dto.external.Movie;
import namoo.yorizori.service.external.CrawlingService;

/**
 * Servlet implementation class ReserveListController
 */
@WebServlet("/movie/reserve/list.do")
public class ReserveListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrawlingService crawlingService = ServiceFactoryImpl.getInstance().getCrawlingService();
		List<Movie> list = crawlingService.reserveMovieList();
		System.out.println(list.size());
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/movie/reserveList.jsp").forward(request, response);
	}
}
