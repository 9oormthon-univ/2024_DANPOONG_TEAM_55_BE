package goormthon.somtoring.domain.user.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goormthon.somtoring.domain.user.domain.Role;
import goormthon.somtoring.domain.user.domain.User;
import goormthon.somtoring.domain.user.domain.UserRepository;
import goormthon.somtoring.domain.user.presentation.exception.UserNotFoundException;
import goormthon.somtoring.domain.user.presentation.response.UserDetailResponse;
import goormthon.somtoring.domain.user.presentation.response.UserNicknameResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public void selectUserRole(Long userId, Role role) {
		User user = getByUserId(userId);
		user.selectRole(role);
	}

	public UserNicknameResponse getUserNickname(Long userId) {
		return UserNicknameResponse.from(me(userId));
	}

	public UserDetailResponse getUserMe(Long userId) {
		return UserDetailResponse.from(me(userId));
	}

	public User me(Long userId) {
		return getByUserId(userId);
	}

	public User getByUserId(Long userId) {
		return userRepository.findById(userId)
			.orElseThrow(UserNotFoundException::new);
	}
}
