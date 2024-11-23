package goormthon.somtoring.domain.tag.infrastructure;

import goormthon.somtoring.domain.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagJpaRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByIdIn(List<Long> tagIds);
}
