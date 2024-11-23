package goormthon.somtoring.domain.tag.application;

import goormthon.somtoring.domain.tag.domain.Tag;
import goormthon.somtoring.domain.tag.domain.TagRepository;
import goormthon.somtoring.domain.tag.presentation.exception.TagNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    @Transactional(readOnly = true)
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
