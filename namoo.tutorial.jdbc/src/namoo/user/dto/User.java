package namoo.user.dto;
/**
 * User DTO 데이터를 주고 반는 역할
 * @author 정충효
 *
 */
public class User {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String regdate; //DATE 타입이지만 그래도 String으로 해준다

	public User() {
		this(null,null,null,null,null); //명시적으로 초기화 원래 자동으로 됨
	}
	/**regdte는 디폴트가 있기에 이렇게도 가능 */
	public User(String id, String passwd, String name, String email) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
	}

	public User(String id, String passwd, String name, String email, String regdate) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.regdate = regdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String toString() {
		return id+"\t****\t"+name+"\t"+email+"\t"+regdate;
		
	}


}
