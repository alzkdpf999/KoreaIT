package namoo.yorizori.service.external;

import java.util.List;

import org.jsoup.nodes.Element;

import namoo.yorizori.dto.external.Movie;

public interface CrawlingService {
	/** cgv 영화사이트 상영 예정작 목록 반환 */
	public List<Movie> reserveMovieList();
}
