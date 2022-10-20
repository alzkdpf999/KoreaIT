package namoo.springJPA.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;

import namoo.springJPA.entity.user.Member;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {


}
