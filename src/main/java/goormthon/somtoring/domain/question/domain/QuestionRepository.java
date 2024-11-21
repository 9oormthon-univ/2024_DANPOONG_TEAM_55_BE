package goormthon.somtoring.domain.question.domain;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {
	Optional<Question> findById(Long id);
	List<Question> findAll();
}
