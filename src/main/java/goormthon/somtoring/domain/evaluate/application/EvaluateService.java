package goormthon.somtoring.domain.evaluate.application;

import goormthon.somtoring.domain.evaluate.domain.Evaluate;
import goormthon.somtoring.domain.evaluate.domain.EvaluateRepository;
import goormthon.somtoring.domain.evaluate.presentation.response.EvaluateSelectResponse;
//import goormthon.somtoring.domain.evaluateTag.application.EvaluateTagService;
import goormthon.somtoring.domain.evaluateTag.application.EvaluateTagService;
import goormthon.somtoring.domain.evaluateTag.domain.EvaluateTag;
import goormthon.somtoring.domain.evaluateTag.domain.EvaluateTagRepository;
import goormthon.somtoring.domain.tag.application.TagService;
import goormthon.somtoring.domain.tag.domain.Tag;
import goormthon.somtoring.domain.tag.domain.TagType;
import goormthon.somtoring.domain.user.application.UserService;
import goormthon.somtoring.domain.user.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluateService {

    private final UserService userService;
    private final TagService tagService;
    private final EvaluateRepository evaluateRepository;
    private final EvaluateTagService evaluateTagService;
    private final EvaluateTagRepository evaluateTagRepository;

    @Transactional(readOnly = true)
    public EvaluateSelectResponse getMentorForEvaluate (Long mentorId) {
        User user = userService.getByUserId(mentorId);
        List<Tag> tags = tagService.getAllTags();
        return EvaluateSelectResponse.of(user, tags);
    }

    @Transactional
    public void evaluateMentor (Long userId, Long mentorId, List<Long> tagIds) {
        User mentor = userService.getByUserId(mentorId);
        User mentee = userService.getByUserId(userId);
        List<Tag> tags = tagService.getTagsByIds(tagIds);

        long goodTagCount = tags.stream()
                .filter(tag -> tag.getTagType() == TagType.GOOD)
                .count();
        long badTagCount = tags.stream()
                .filter(tag -> tag.getTagType() == TagType.BAD)
                .count();
        int score = calculateScore((int) goodTagCount, (int) badTagCount);
        mentor.setSugar(mentor.getSugar() + score);
        Evaluate evaluate = Evaluate.builder()
                .mentor(mentor)
                .mentee(mentee)
                .build();

        evaluateRepository.save(evaluate);
        evaluateTagService.saveEvaluateTags(evaluate, tags);
    }

    private int calculateScore (int goodTagCount, int badTagCount) {
        return (goodTagCount * 2) - (badTagCount * 2);
    }

    public Evaluate getUserById(Long userId) {
        return evaluateRepository.findByMentee_Id(userId);
    }
}
