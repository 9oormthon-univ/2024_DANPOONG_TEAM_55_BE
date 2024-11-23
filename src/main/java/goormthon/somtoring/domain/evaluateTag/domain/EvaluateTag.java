package goormthon.somtoring.domain.evaluateTag.domain;

import goormthon.somtoring.common.domain.BaseTimeEntity;
import goormthon.somtoring.domain.evaluate.domain.Evaluate;
import goormthon.somtoring.domain.tag.domain.Tag;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class EvaluateTag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluate_id")
    private Evaluate evaluate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public static EvaluateTag of(Evaluate evaluate, Tag tag) {
        return EvaluateTag.builder()
                .evaluate(evaluate)
                .tag(tag)
                .build();
    }
}
