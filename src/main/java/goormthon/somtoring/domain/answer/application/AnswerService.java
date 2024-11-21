package goormthon.somtoring.domain.answer.application;

import org.springframework.stereotype.Service;

import goormthon.somtoring.domain.answer.domain.Answer;
import goormthon.somtoring.domain.answer.domain.AnswerRepository;
import goormthon.somtoring.domain.answer.presentation.exception.AnswerNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {
	private final AnswerRepository answerRepository;

	public Answer getAnswer(Long answerId) {
		return answerRepository.findById(answerId)
				.orElseThrow(AnswerNotFoundException::new);
	}
}
