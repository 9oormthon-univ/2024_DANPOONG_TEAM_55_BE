package goormthon.somtoring.domain.evaluate.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goormthon.somtoring.domain.evaluate.domain.Evaluate;
import goormthon.somtoring.domain.evaluate.domain.EvaluateRepository;
import goormthon.somtoring.domain.evaluate.presentation.request.EvaluateRequest;
import goormthon.somtoring.domain.evaluate.presentation.response.EvaluateSelectResponse;
import goormthon.somtoring.domain.evaluateTag.application.EvaluateTagService;
import goormthon.somtoring.domain.tag.application.TagService;
import goormthon.somtoring.domain.tag.domain.Tag;
import goormthon.somtoring.domain.tag.domain.TagType;
import goormthon.somtoring.domain.user.application.UserService;
import goormthon.somtoring.domain.user.domain.user.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EvaluateService {

    private final UserService userService;
    private final TagService tagService;
    private final EvaluateRepository evaluateRepository;
    private final EvaluateTagService evaluateTagService;

    @Transactional(readOnly = true)
    public EvaluateSelectResponse getMentorForEvaluate (Long mentorId) {
        User user = userService.getByUserId(mentorId);
        List<Tag> tags = tagService.getAllTags();
        return EvaluateSelectResponse.of(user, tags);
    }

    @Transactional
    public void evaluateMentor (Long userId, Long mentorId, EvaluateRequest request) {
        User mentor = userService.getByUserId(mentorId);
        User mentee = userService.getByUserId(userId);
        int score = calculateScore(
            tagService.getTagCountByTagType(request.tagIds(), TagType.GOOD),
            tagService.getTagCountByTagType(request.tagIds(), TagType.BAD));
        mentor.setSugar(mentor.getSugar() + score);
        Evaluate evaluate = Evaluate.of(mentor, mentee);
        evaluateRepository.save(evaluate);

        List<Tag> tags = tagService.getTagsByIds(request.tagIds());
        evaluateTagService.saveEvaluateTags(evaluate, tags);
    }

    private int calculateScore (int goodTagCount, int badTagCount) {
        return (goodTagCount * 2) - (badTagCount * 2);
    }
}
