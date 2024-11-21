package goormthon.somtoring.domain.answer.infrastructure;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.answer.domain.Answer;
import goormthon.somtoring.domain.answer.domain.AnswerRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AnswerRepositoryImpl implements AnswerRepository {
	private final AnswerJpaRepository answerJpaRepository;
	@Override
	public Optional<Answer> findById(Long id) {
		return answerJpaRepository.findById(id);
	}
}
