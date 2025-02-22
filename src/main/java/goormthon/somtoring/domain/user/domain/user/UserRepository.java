package goormthon.somtoring.domain.user.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

	User save(User user);

	Optional<User> findById(Long userId);

	Optional<User> findByEmail(String email);

	List<User> findAllByRoleAndVarki(Role role, Varki varki);

	Optional<User> findByIdAndRole(Long userid, Role role);

	List<User> findByRole(Role role);
}
