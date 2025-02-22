package goormthon.somtoring.domain.tag.domain;

import goormthon.somtoring.common.domain.BaseTimeEntity;
import goormthon.somtoring.domain.evaluateTag.domain.EvaluateTag;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TagType tagType;

    private String content;

    public Tag(TagType tagType, String content) {
        this.tagType = tagType;
        this.content = content;
    }
}
