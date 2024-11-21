package goormthon.somtoring.domain.answer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import goormthon.somtoring.domain.answer.domain.Answer;

public interface AnswerJpaRepository extends JpaRepository<Answer, Long> {
}
