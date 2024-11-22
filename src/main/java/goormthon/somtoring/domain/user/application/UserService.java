package goormthon.somtoring.domain.user.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goormthon.somtoring.domain.user.domain.user.Role;
import goormthon.somtoring.domain.user.domain.user.User;
import goormthon.somtoring.domain.user.domain.user.UserRepository;
import goormthon.somtoring.domain.user.domain.tag.UserTag;
import goormthon.somtoring.domain.user.presentation.exception.UserNotFoundException;
import goormthon.somtoring.domain.user.presentation.request.UserAdditionalRequest;
import goormthon.somtoring.domain.user.presentation.response.UserDetailResponse;
import goormthon.somtoring.domain.user.presentation.response.UserNicknameResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final UserTagService userTagService;

	@Transactional
	public void selectUserRole(Long userId, Role role) {
		User user = getByUserId(userId);
		user.selectRole(role);
	}

	public UserNicknameResponse getUserNickname(Long userId) {
		return UserNicknameResponse.from(getByUserId(userId));
	}

	@Transactional
	public void updateUserAdditionalInfo(Long userId, UserAdditionalRequest request) {
		User user = getByUserId(userId);
		user.updateUniversity(request.university());
		user.updateAdditionalInfo(request.additionalInfo());
		List<UserTag> userTags = request.tags()
			.stream()
			.map(tag -> UserTag.of(tag, user))
			.toList();
		userTagService.saveUserTags(userTags);
	}

	public UserDetailResponse getUserMe(Long userId) {
		return UserDetailResponse.from(getByUserId(userId));
	}

	public User getByUserId(Long userId) {
		return userRepository.findById(userId)
			.orElseThrow(UserNotFoundException::new);
	}
}
