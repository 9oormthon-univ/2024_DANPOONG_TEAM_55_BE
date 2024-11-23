package goormthon.somtoring.domain.evaluate.infrastructure;

import goormthon.somtoring.domain.evaluate.domain.Evaluate;
import goormthon.somtoring.domain.evaluate.domain.EvaluateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EvaluateRepositoryImpl implements EvaluateRepository {

    private final EvaluateJpaRepository evaluateJpaRepository;

    @Override
    public void save(Evaluate evaluate) {
        evaluateJpaRepository.save(evaluate);
    }

    @Override
    public Evaluate findByMentee_Id(Long userId) {
        return evaluateJpaRepository.findByMentee_Id(userId);
    }

}
