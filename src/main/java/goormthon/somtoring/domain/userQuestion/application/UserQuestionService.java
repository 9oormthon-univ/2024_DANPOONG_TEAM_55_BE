package goormthon.somtoring.domain.userQuestion.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goormthon.somtoring.domain.answer.application.AnswerService;
import goormthon.somtoring.domain.answer.domain.Answer;
import goormthon.somtoring.domain.question.domain.Question;
import goormthon.somtoring.domain.user.application.UserService;
import goormthon.somtoring.domain.user.domain.user.User;
import goormthon.somtoring.domain.userQuestion.domain.UserQuestion;
import goormthon.somtoring.domain.userQuestion.domain.UserQuestionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserQuestionService {
	private final UserQuestionRepository userQuestionRepository;
	private final UserService userService;
	private final AnswerService answerService;

	@Transactional
	public void answerQuestion(Long userId, Question question, Long answerId) {
		User user = userService.getByUserId(userId);
		Answer answer = answerService.getAnswer(answerId);
		UserQuestion userQuestion = UserQuestion.of(user, question, answer);
		userQuestionRepository.save(userQuestion);
	}

	public List<Long> getAnsweredQuestionIds(Long userId) {
		return userQuestionRepository.findAnsweredQuestionIds(userId);
	}
}
