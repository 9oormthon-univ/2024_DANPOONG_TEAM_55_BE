package goormthon.somtoring.domain.user.infrastructure.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import goormthon.somtoring.domain.user.domain.user.Role;
import goormthon.somtoring.domain.user.domain.user.User;
import goormthon.somtoring.domain.user.domain.user.Varki;

public interface UserJpaRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

	Optional<User> findByIdAndRole(Long userid, Role role);

	List<User> findByRole(Role role);
}
