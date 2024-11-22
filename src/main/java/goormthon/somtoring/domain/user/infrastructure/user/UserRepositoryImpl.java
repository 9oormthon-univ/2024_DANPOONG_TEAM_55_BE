package goormthon.somtoring.domain.user.infrastructure.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.user.domain.user.Role;
import goormthon.somtoring.domain.user.domain.user.User;
import goormthon.somtoring.domain.user.domain.user.UserRepository;

import goormthon.somtoring.domain.user.domain.user.Varki;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
	private final UserQueryRepository userQueryRepository;
	private final UserJpaRepository userJpaRepository;

	@Override
	public User save(User user) {
		return userJpaRepository.save(user);
	}

	@Override
	public Optional<User> findById(Long userId) {
		return userJpaRepository.findById(userId);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userJpaRepository.findByEmail(email);
	}

	@Override
	public List<User> findAllByRoleAndVarki(Role role, Varki varki) {
		return userQueryRepository.findAllByRoleAndVarki(role, varki);
	}
}
