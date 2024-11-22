package goormthon.somtoring.domain.userQuestion.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goormthon.somtoring.domain.answer.application.AnswerService;
import goormthon.somtoring.domain.answer.domain.Answer;
import goormthon.somtoring.domain.question.domain.Question;
import goormthon.somtoring.domain.user.application.UserService;
import goormthon.somtoring.domain.user.domain.user.User;
import goormthon.somtoring.domain.user.domain.user.UserRepository;
import goormthon.somtoring.domain.user.domain.user.Varki;
import goormthon.somtoring.domain.user.presentation.exception.UserNotFoundException;
import goormthon.somtoring.domain.userQuestion.domain.UserQuestion;
import goormthon.somtoring.domain.userQuestion.domain.UserQuestionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserQuestionService {
	private final UserQuestionRepository userQuestionRepository;
	private final UserRepository userRepository;
	private final AnswerService answerService;

	@Transactional
	public void answerQuestion(Long userId, Question question, Long answerId) {
		User user = userRepository.findById(userId)
			.orElseThrow(UserNotFoundException::new);
		Answer answer = answerService.getAnswer(answerId);
		UserQuestion userQuestion = UserQuestion.of(user, question, answer);
		userQuestionRepository.save(userQuestion);
	}

	public List<Long> getAnsweredQuestionIds(Long userId) {
		return userQuestionRepository.findAnsweredQuestionIds(userId);
	}

	public void calculateVarki(User user) {
		List<UserQuestion> userQuestions = userQuestionRepository.findAllByUserId(user.getId());
		int v = 0, a = 0, r = 0, k = 0, i = 0;
		for (UserQuestion userQuestion : userQuestions) {
			Question question = userQuestion.getQuestion();
			Answer answer = userQuestion.getAnswer();
			if (question.isV()) v += answer.getScore();
			if (question.isA()) a += answer.getScore();
			if (question.isR()) r += answer.getScore();
			if (question.isK()) k += answer.getScore();
			if (question.isI()) i += answer.getScore();
		}
		Varki varki = Varki.of(v, a, r, k, i);
		user.updateVarki(varki);
	}
}
