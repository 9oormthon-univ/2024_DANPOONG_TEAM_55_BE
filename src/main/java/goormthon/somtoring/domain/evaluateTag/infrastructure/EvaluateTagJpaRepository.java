package goormthon.somtoring.domain.evaluateTag.infrastructure;

import goormthon.somtoring.domain.evaluateTag.domain.EvaluateTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluateTagJpaRepository extends JpaRepository<EvaluateTag, Long> {
}
