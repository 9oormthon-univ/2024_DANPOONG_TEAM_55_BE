package goormthon.somtoring.domain.user.application;

import static goormthon.somtoring.domain.user.domain.user.Role.MENTOR;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goormthon.somtoring.domain.user.domain.tag.UserTag;
import goormthon.somtoring.domain.user.domain.user.Role;
import goormthon.somtoring.domain.user.domain.user.User;
import goormthon.somtoring.domain.user.domain.user.UserRepository;
import goormthon.somtoring.domain.user.domain.user.Varki;
import goormthon.somtoring.domain.user.presentation.exception.UserNotFoundException;
import goormthon.somtoring.domain.user.presentation.request.UserAdditionalRequest;
import goormthon.somtoring.domain.user.presentation.response.UserDetailResponse;
import goormthon.somtoring.domain.user.presentation.response.UserNicknameResponse;
import goormthon.somtoring.domain.user.presentation.response.UserSummaryListResponse;
import goormthon.somtoring.domain.userQuestion.application.UserQuestionService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final UserTagService userTagService;
	private final UserQuestionService userQuestionService;

	@Transactional
	public void selectUserRole(Long userId, Role role) {
		User user = getByUserId(userId);
		user.selectRole(role);
		user.setSugar(10);
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

	@Transactional
	public UserDetailResponse getUserMe(Long userId) {
		User user = getByUserId(userId);
		if (user.getVarki() == null) userQuestionService.calculateVarki(user);
		return UserDetailResponse.from(user);
	}

	@Transactional(readOnly = true)
	public UserSummaryListResponse getMentors(Long userId) {
		Varki myVarki = getByUserId(userId).getVarki();
		List<User> mentors = userRepository.findAllByRoleAndVarki(MENTOR, myVarki);
		return UserSummaryListResponse.from(mentors);

	}

	public User getByUserId(Long userId) {
		return userRepository.findById(userId)
			.orElseThrow(UserNotFoundException::new);
	}

	public User getByUserIdAndRole(Long userId, Role role) {
		return userRepository.findByIdAndRole(userId, role)
			.orElseThrow(UserNotFoundException::new);
	}
}
