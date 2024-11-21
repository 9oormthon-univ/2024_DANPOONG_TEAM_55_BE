package goormthon.somtoring.domain.question.infrastructure;

import goormthon.somtoring.domain.question.domain.Question;
import goormthon.somtoring.domain.question.presentation.exception.QuestionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {

    private final QuestionJpaRepository questionJpaRepository;

    public void save (Question question) {
        questionJpaRepository.save(question);
    }

    public Question findByQuestionWithId(Long questionId) {
        return questionJpaRepository.findById(questionId).orElseThrow(QuestionNotFoundException::new);
    }
}
