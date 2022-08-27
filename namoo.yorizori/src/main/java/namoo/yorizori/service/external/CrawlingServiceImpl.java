package namoo.yorizori.service.external;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import namoo.yorizori.dto.external.Movie;

public class CrawlingServiceImpl implements CrawlingService {
	
	@Override
	/**
	 * cgv 영화사이트 상영 예정작 목록 반환
	 */
	public List<Movie> reserveMovieList() {
		String url = "https://www.cgv.co.kr/";
		List<Movie> list = new ArrayList<Movie>();
		Document document = null;
		try {
//			웹서버 연결 및 GET 방식 요청으로 HTML 수신/파싱
			document = Jsoup.connect(url).get();
//			select() 메소드를 이용하여 html의 특정 요소를 읽기
			Element titleElement =  document.selectFirst("#btnReserMovie");
			String titleText = titleElement.text();
			System.out.println(titleText);

			Elements elements = document.select("div.movie_info_wrap");
			Iterator<Element> iter = elements.iterator();
			while (iter.hasNext()) {
				Element element = iter.next();
				String title = element.child(0).text();
				String rate = element.child(2).text();
				Movie movie = new Movie(title, rate);
				list.add(movie);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		CrawlingService crawlingService = new CrawlingServiceImpl();
		List <Movie> list  =crawlingService.reserveMovieList();
		Iterator<Movie> iter = list.iterator();
		while(iter.hasNext()) {
			Movie movie = iter.next();
			System.out.println(movie.getTitle()+"," +movie.getRate());
		}
	}
}
