package namoo.springTrans.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
		name = "member_seq_gen",  //시퀀스 생성 이름
		sequenceName = "member_seq", //DB시퀀스 이름
		initialValue = 1, //시작값 생략가능
		allocationSize = 1) //JPA에서 가상으로 관리할 시퀀스 범위
//기본값은 50이며 , 1로 설정한 경우 매번 insert시 DB시퀀스 사용
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id//식별자 알려주기
	@Column(name="member_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
	private Long id; // 회원 아이디	
	
	private String name; // 회원 이름
	private int age; // 회원 나이
}
