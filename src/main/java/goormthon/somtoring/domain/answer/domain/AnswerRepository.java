package goormthon.somtoring.domain.answer.domain;

import java.util.Optional;

public interface AnswerRepository {
	Optional<Answer> findById(Long id);
}
