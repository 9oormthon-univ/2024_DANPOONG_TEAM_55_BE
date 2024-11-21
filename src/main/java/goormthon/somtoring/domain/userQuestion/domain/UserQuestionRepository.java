package goormthon.somtoring.domain.userQuestion.domain;

import java.util.List;
import java.util.Optional;

public interface UserQuestionRepository {
	void save(UserQuestion userQuestion);
	List<Long> findAnsweredQuestionIds(Long userId);

}
