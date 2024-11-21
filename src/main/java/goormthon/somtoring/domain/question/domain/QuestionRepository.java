package goormthon.somtoring.domain.question.domain;

import java.util.List;

public interface QuestionRepository {

	List<Question> findAll();
}
