package goormthon.somtoring.domain.evaluateTag.infrastructure;

import goormthon.somtoring.domain.evaluateTag.domain.EvaluateTag;
import goormthon.somtoring.domain.evaluateTag.domain.EvaluateTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EvaluateTagRepositoryImpl implements EvaluateTagRepository {

    private final EvaluateTagJpaRepository evaluateTagJpaRepository;

    @Override
    public void save (EvaluateTag evaluateTag) {
        evaluateTagJpaRepository.save(evaluateTag);
    }
}
