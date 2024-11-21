package goormthon.somtoring.domain.question.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.question.domain.Question;
import goormthon.somtoring.domain.question.domain.QuestionRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {
	private final QuestionJpaRepository questionJpaRepository;

	@Override
	public Optional<Question> findById(Long id) {
		return questionJpaRepository.findById(id);
	}

	@Override
	public List<Question> findAll() {
		return questionJpaRepository.findAll();
	}
}
