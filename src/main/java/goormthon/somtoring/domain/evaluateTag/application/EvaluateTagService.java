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
        tags.forEach(tag -> {
            EvaluateTag evaluateTag = EvaluateTag.of(evaluate, tag);
            evaluateTagRepository.save(evaluateTag);
        });
    }
}
