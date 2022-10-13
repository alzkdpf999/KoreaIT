package namoo.springJPA.repository.user;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.entity.user.User;

@Slf4j
@Repository
//JPA의 모든 데이터 변경(등록, 수정, 삭제)은 트랜잭션 안에서 이루어져야 한다.
//JPA에서는 데이터 변경시 트랜잭션이 필수다.
//일반적으로는 비즈니스 로직을 시작하는 서비스 계층에서 트랜잭션을 걸어준다.
@Transactional
public class JpaUserRepository implements UserRepository {

	// 스프링 부트와 통합되어 복잡한 설정(DataSource 설정 등) 없이 주입 받을 수 있다.
	// JPA의 모든 동작은 EntityManager를 통해서 이루어진다.
	// EntityManager는 내부에 DataSource를 가지고 있고, 커넥션풀을 통해 데이터베이스에 접근한다.
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void create(User user) {
		
	}

	@Override
	public User findById(String id) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public void update(User user) {
		
	}

}
