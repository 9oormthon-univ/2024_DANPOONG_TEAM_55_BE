package goormthon.somtoring.domain.evaluateTag.application;


import goormthon.somtoring.domain.evaluate.domain.Evaluate;
import goormthon.somtoring.domain.evaluateTag.domain.EvaluateTag;
import goormthon.somtoring.domain.evaluateTag.domain.EvaluateTagRepository;
import goormthon.somtoring.domain.tag.domain.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluateTagService {

    private final EvaluateTagRepository evaluateTagRepository;

    @Transactional
    public void saveEvaluateTags(Evaluate evaluate, List<Tag> tags) {
        for (Tag tag : tags) {
            EvaluateTag evaluateTag = createEvaluateTag(evaluate, tag);
            evaluateTagRepository.save(evaluateTag);
        }
    }

    private EvaluateTag createEvaluateTag(Evaluate evaluate, Tag tag) {
        return EvaluateTag.of(evaluate, tag);
    }
}
