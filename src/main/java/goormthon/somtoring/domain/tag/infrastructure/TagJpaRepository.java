package goormthon.somtoring.domain.tag.infrastructure;

import goormthon.somtoring.domain.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagJpaRepository extends JpaRepository<Tag, Long> {

}
