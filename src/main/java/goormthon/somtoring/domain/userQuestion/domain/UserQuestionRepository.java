package goormthon.somtoring.domain.userQuestion.domain;

import java.util.List;
import java.util.Optional;

public interface UserQuestionRepository {
	// Optional<UserQuestion> findNextQuestionNotAnswered(Long userId, List<Long> questionIds);

	List<Long> findAnsweredQuestionIds(Long userId);

}
