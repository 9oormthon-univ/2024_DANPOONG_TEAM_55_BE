package goormthon.somtoring.domain.evaluate.infrastructure;

import goormthon.somtoring.domain.evaluate.domain.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluateJpaRepository extends JpaRepository<Evaluate, Long> {
    Evaluate findByMentee_Id(Long userId);
}
