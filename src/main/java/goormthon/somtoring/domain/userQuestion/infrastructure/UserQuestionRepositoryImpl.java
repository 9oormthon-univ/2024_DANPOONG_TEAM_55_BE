package goormthon.somtoring.domain.userQuestion.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.userQuestion.domain.UserQuestion;
import goormthon.somtoring.domain.userQuestion.domain.UserQuestionRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserQuestionRepositoryImpl implements UserQuestionRepository {
	private final UserQuestionJpaRepository userQuestionJpaRepository;
	private final UserQuestionQueryRepository userQuestionQueryRepository;

	@Override
	public void save(UserQuestion userQuestion) {
		userQuestionJpaRepository.save(userQuestion);
	}

	@Override
	public List<Long> findAnsweredQuestionIds(Long userId) {
		return userQuestionQueryRepository.findAnsweredQuestionIds(userId);
	}

	@Override
	public List<UserQuestion> findAllByUserId(Long userId) {
		return userQuestionJpaRepository.findAllByUserId(userId);
	}

	@Override
	public void deleteAllByUserId(Long userId) {
		userQuestionJpaRepository.deleteAllByUserId(userId);
	}
}
