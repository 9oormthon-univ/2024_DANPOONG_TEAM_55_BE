package goormthon.somtoring.domain.question.domain;

import goormthon.somtoring.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question")
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "questionText", joinColumns = @JoinColumn(name = "question_id"))
    private List<String> questionText = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "questionScore", joinColumns = @JoinColumn(name = "question_id"))
    private List<Integer> questionScore = new ArrayList<>();

    @Builder
    public Question(List<String> questionText, List<Integer> questionScore) {
        this.questionText = questionText;
        this.questionScore = questionScore;
    }
}
