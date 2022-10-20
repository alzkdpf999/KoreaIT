package namoo.springJPA.Service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import namoo.springJPA.entity.user.User;
import namoo.springJPA.repository.user.UserRepository;

@Service
public class Serviceimple implements Servicetest {

	
	@Autowired
	private UserRepository userRepository; 
	
	
	public void create(User user) {
		// TODO Auto-generated method stub
		userRepository.create(user);
	}


	@Override
	@Transactional
	public void 계좌이체() {

	}
}
