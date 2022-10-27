package namoo.springTrans.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="orders")
@SequenceGenerator(
		name="order_seq_gen",
		sequenceName="order_seq",
		allocationSize = 1)
@Data
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
	private Long id;
	private String username;
	private String payStatus; // 대기, 완료
}
//create sequence order_seq; 생성 필요
