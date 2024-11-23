package goormthon.somtoring.domain.tag.domain;

import goormthon.somtoring.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TagType tagType;

    private String content;

    private int score;

    @Builder
    public Tag(TagType tagType, String content, int score) {
        this.tagType = tagType;
        this.content = content;
        this.score = score;
    }
}
