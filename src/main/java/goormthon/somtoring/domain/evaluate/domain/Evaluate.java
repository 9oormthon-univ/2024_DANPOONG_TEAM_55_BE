package goormthon.somtoring.domain.evaluate.domain;

import goormthon.somtoring.common.domain.BaseTimeEntity;
import goormthon.somtoring.domain.evaluateTag.domain.EvaluateTag;
import goormthon.somtoring.domain.user.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Evaluate extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private User mentor;

    @ManyToOne
    @JoinColumn(name = "mentee_id")
    private User mentee;
}