package goormthon.somtoring.domain.user.infrastructure;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.user.domain.User;
import goormthon.somtoring.domain.user.domain.UserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
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
}
