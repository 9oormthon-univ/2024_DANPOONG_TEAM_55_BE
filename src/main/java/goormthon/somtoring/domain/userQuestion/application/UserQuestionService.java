package goormthon.somtoring.domain.userQuestion.application;

import java.util.List;

import org.springframework.stereotype.Service;

import goormthon.somtoring.domain.userQuestion.domain.UserQuestionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserQuestionService {
	private final UserQuestionRepository userQuestionRepository;

	// public UserQuestion getNextQuestion(Long userId, List<Long> questionIds) {
	// 	return userQuestionRepository.findNextQuestionNotAnswered(userId, questionIds)
	// 		.orElseThrow(UnansweredQuestionNotExistsException::new);
	// }

	public List<Long> getAnsweredQuestionIds(Long userId) {
		return userQuestionRepository.findAnsweredQuestionIds(userId);
	}
}
