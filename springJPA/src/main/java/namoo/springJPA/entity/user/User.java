package namoo.springJPA.entity.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author 정충효
 * JPA 사용
 */
@Entity// JPA가 사용하는 객체라는 의미의 어노테이션(JPA)가 인식
@Table(name= "users") //sql 테이블값아 클래스명이 같으면 생략 아니면 써줌
@DynamicInsert //sql 디폴트값 자동 입력
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id //테이블의 pk와 해당 필드 매핑
	private String id;
//	@Column(name="name") // 칼럼명 다를때에만 같으면 생략 가능
	private String passwd;
	private String name;
	private String email;
	
	// SQL 데이터타입 설정
	//@Temporal(TemporalType.DATE) 년원일
	//@Temporal(TemporalType.TIME) 시분초
	//@Temporal(TemporalType.TIMESTAMP) : 디폴트 년월일 시분초 
	private Date regdate;



	
}





