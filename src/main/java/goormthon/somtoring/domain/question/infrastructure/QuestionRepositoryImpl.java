package goormthon.somtoring.domain.question.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.question.domain.Question;
import goormthon.somtoring.domain.question.domain.QuestionRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {
	private final QuestionJpaRepository questionJpaRepository;

	@Override
	public List<Question> findAll() {
		return questionJpaRepository.findAll();
	}
}
