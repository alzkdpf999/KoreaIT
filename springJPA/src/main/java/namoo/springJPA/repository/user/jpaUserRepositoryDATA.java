package namoo.springJPA.repository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.entity.user.User;

@Slf4j
//JPA의 모든 데이터 변경(등록, 수정, 삭제)은 트랜잭션 안에서 이루어져야 한다.
//JPA에서는 데이터 변경시 트랜잭션이 필수다.
//일반적으로는 비즈니스 로직을 시작하는 서비스 계층에서 트랜잭션을 걸어준다.
@Transactional
@Repository
public class jpaUserRepositoryDATA implements UserRepository {

	@Autowired
	private SpringDataJpaUserRepository userRepository;

	public void create(User user) {
		userRepository.save(user);
	}

	@Override

	public User findById(String id) {
		Optional<User> option = userRepository.findById(id);
		/*
		 * if (!option.isPresent()) { throw new RuntimeException(id + "오류"); }
		 */

		return option.get();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void update(User user) {
		User findUser = findById(user.getId());
		findUser.setPasswd(user.getPasswd());
		findUser.setEmail(user.getEmail());
	}

	public List<User> findName(String name) {
		return userRepository.findAllByNameContaining(name);
	}

	@Override
	public List<User> findByName(String name) {
		
		return userRepository.findAllByName(name);
	}

	@Override
	public List<User> findLastName(String lastName) {
		// TODO Auto-generated method stub
		return userRepository.findAllByNameStartingWith(lastName);
	}
	

}
