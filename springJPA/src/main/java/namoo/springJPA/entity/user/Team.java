package namoo.springJPA.entity.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
		name = "team_seq_gen", 
		sequenceName = "team_seq", 
		initialValue = 1, 
		allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq_gen")
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "team")
	/** members에 등록되어 잇는 Member의 team 속성에 매핑되었음을 의미
	 *  연관관계의 주인이 Member의 team임을 설정
	 *  오로지 읽기만 하도록 설정하는거
	 * 	@joinColumn 설정 안함
	 * */
	
	private List<Member> members = new ArrayList<Member>();
}
