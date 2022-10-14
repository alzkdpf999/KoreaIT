package namoo.springJPA.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import namoo.springJPA.entity.user.User;

public interface SpringDataJpaUserRepository  extends JpaRepository<User, String>{
	List<User> findAllByFirstnameContaining(String name);
	
	List<User> findAllByName(String name);
}
 	