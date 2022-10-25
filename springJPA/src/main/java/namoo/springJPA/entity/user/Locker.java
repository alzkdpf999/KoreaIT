package namoo.springJPA.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 일대일 단반향 버전
 * @author 정충효
 *
 */
@Entity
@SequenceGenerator(
		name = "locker_seq_gen",  //시퀀스 생성 이름
		sequenceName = "locker_seq", //DB시퀀스 이름
		initialValue = 1, //시작값 생략가능
		allocationSize = 1) //JPA에서 가상으로 관리할 시퀀스 범위
//기본값은 50이며 , 1로 설정한 경우 매번 insert시 DB시퀀스 사용
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locker {
	@Id//식별자 알려주기
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locker_seq_gen")
	private Long id;
	
	@OneToOne(mappedBy = "locker")
	private Member member;
	private String name;
}
