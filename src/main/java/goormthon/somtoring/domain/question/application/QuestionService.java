package goormthon.somtoring.domain.question.application;

import goormthon.somtoring.domain.question.domain.Question;
import goormthon.somtoring.domain.question.infrastructure.QuestionRepository;
import goormthon.somtoring.domain.question.presentation.response.QuestionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public void save (QuestionResponse questionResponse) {

        List<Integer> questionScore = new ArrayList<>();
        for(int i = 0; i < questionResponse.questionText().size(); i++) {
            questionScore.add(i + 1);
        }
        Question question = Question.builder()
                .questionText(questionResponse.questionText())
                .questionScore(questionScore)
                .build();

        questionRepository.save(question);
    }
}
