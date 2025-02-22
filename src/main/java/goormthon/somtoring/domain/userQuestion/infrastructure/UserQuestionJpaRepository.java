package goormthon.somtoring.domain.userQuestion.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import goormthon.somtoring.domain.userQuestion.domain.UserQuestion;

public interface UserQuestionJpaRepository extends JpaRepository<UserQuestion, Long>{
	List<UserQuestion> findAllByUserId(Long userId);

	void deleteAllByUserId(Long userId);
}
