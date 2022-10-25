package namoo.springJPA.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import namoo.springJPA.entity.user.Locker;

public interface JpaLockerRepository extends JpaRepository<Locker, Long> {

}
