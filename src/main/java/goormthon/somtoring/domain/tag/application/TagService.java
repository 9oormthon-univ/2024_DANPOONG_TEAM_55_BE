package goormthon.somtoring.domain.tag.application;

import goormthon.somtoring.domain.tag.domain.Tag;
import goormthon.somtoring.domain.tag.domain.TagRepository;
import goormthon.somtoring.domain.tag.domain.TagType;
import goormthon.somtoring.domain.tag.presentation.exception.TagNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    @Transactional(readOnly = true)
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public List<Tag> getTagsByIds(List<Long> tagIds) {
        return tagRepository.findByIdIn(tagIds);
    }

    public int getTagCountByTagType(List<Long> tagIds, TagType tagType) {
        List<Tag> tags = new ArrayList<>();
        tagIds.forEach(tagId -> {
            tags.add(tagRepository.findById(tagId).orElseThrow());
        });
        return (int)tags.stream()
            .filter(tag -> tag.getTagType() == tagType)
            .count();
    }
}
