package namoo.springmvc.dto.user;

/**
 * User DTO
 * @author 김기정
 *
 */
public class User {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String regdate;
	
	public User() {
		this(null, null, null, null, null);
	}
		
	public User(String id, String passwd, String name, String email) {
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
	
	@Override
		public String toString() {
			return id+"\t****\t"+name+"\t"+name+"\t"+regdate;
		}
	
	
}





