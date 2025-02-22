package goormthon.somtoring.domain.question.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goormthon.somtoring.domain.question.domain.Question;
import goormthon.somtoring.domain.question.domain.QuestionRepository;
import goormthon.somtoring.domain.question.presentation.exception.QuestionNotFoundException;
import goormthon.somtoring.domain.question.presentation.exception.UnansweredQuestionNotExistsException;
import goormthon.somtoring.domain.question.presentation.response.QuestionResponse;
import goormthon.somtoring.domain.userQuestion.application.UserQuestionService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
	private final QuestionRepository questionRepository;
	private final UserQuestionService userQuestionService;

	@Transactional(readOnly = true)
	public QuestionResponse getNextQuestion(Long userId) {
		List<Long> answeredQuestionIds = userQuestionService.getAnsweredQuestionIds(userId);
		List<Question> questions = questionRepository.findAll();
		Question nextQuestion = questions.stream()
			.filter(question -> !answeredQuestionIds.contains(question.getId()))
			.findFirst()
			.orElseThrow(UnansweredQuestionNotExistsException::new);
		return QuestionResponse.of(nextQuestion, nextQuestion.getAnswers(), questions.size(),
			answeredQuestionIds.size()+1);
	}

	public void answerQuestion(Long userId, Long questionId, Long answerId) {
		Question question = questionRepository.findById(questionId)
			.orElseThrow(QuestionNotFoundException::new);
		userQuestionService.answerQuestion(userId, question, answerId);
	}

}
