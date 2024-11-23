package goormthon.somtoring.domain.tag.domain;

import java.util.List;
import java.util.Optional;

public interface TagRepository {

    Optional<Tag> findById(Long tagId);

    List<Tag> findAll();

    List<Tag> findByIdIn(List<Long> tagIds);
}
