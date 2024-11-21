package goormthon.somtoring.domain.question.infrastructure;

import java.util.List;

import goormthon.somtoring.domain.question.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionJpaRepository extends JpaRepository<Question, Long>{
}
