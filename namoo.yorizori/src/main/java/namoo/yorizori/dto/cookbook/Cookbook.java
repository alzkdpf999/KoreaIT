package namoo.yorizori.dto.cookbook;

/**
 * Cookbook DTO
 * @author 정충효
 *
 */
public class Cookbook {
	private String book_id; //요리책 Id
	private String book_name; //요리책 이름
	private String book_desc;// 요리책 설명
	private String author_id;//저자 이름
	private String view_num;//조회수 디폴트 0
	private String author_name;
	public Cookbook() {
		this(null,null,null,null,null,null);
	}
	public Cookbook(String book_id, String book_name) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
	}
	public Cookbook(String book_id, String book_name, String book_desc, String author_id,String author_name) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_desc = book_desc;
		this.author_id = author_id;
		this.author_name = author_name;
		
	}
	public Cookbook(String book_id, String book_name, String book_desc, String author_id,String view_num ,String author_name) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_desc = book_desc;
		this.author_id = author_id;
		this.view_num = view_num;
		this.author_name = author_name;
	}
	
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getView_num() {
		return view_num;
	}
	public void setView_num(String view_num) {
		this.view_num = view_num;
	}
	public String getBook_desc() {
		return book_desc;
	}
	public void setBook_desc(String book_desc) {
		this.book_desc = book_desc;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
}
