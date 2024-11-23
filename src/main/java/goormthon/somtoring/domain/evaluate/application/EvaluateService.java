package goormthon.somtoring.domain.evaluate.application;

import goormthon.somtoring.domain.evaluate.presentation.response.EvaluateSelectResponse;
import goormthon.somtoring.domain.tag.application.TagService;
import goormthon.somtoring.domain.tag.domain.Tag;
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

    @Transactional(readOnly = true)
    public EvaluateSelectResponse getMentorForEvaluate (Long mentorId) {
        User user = userService.getByUserId(mentorId);
        List<Tag> tags = tagService.getAllTags();
        return EvaluateSelectResponse.of(user, tags);
    }
}
