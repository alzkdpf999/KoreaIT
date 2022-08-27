package namoo.yorizori.dto.external;

public class Movie {
	private String title;
	private String rate;
	public Movie() {}
	public Movie(String title, String rate) {
		this.title = title;
		this.rate = rate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", rate=" + rate + "]";
	}
}
