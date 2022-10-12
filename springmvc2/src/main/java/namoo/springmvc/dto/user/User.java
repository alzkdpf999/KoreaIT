package namoo.springmvc.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author 정충효
 * Lombok으로 고치기
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String regdate;
	

	
}





