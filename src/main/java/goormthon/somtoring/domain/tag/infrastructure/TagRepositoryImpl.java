package goormthon.somtoring.domain.tag.infrastructure;

import goormthon.somtoring.domain.tag.domain.Tag;
import goormthon.somtoring.domain.tag.domain.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TagRepositoryImpl implements TagRepository {

    private final TagJpaRepository tagJpaRepository;

    @Override
    public Optional<Tag> findById(Long tagId) {
        return tagJpaRepository.findById(tagId);
    }

    @Override
    public List<Tag> findAll() {
        return tagJpaRepository.findAll();
    }
}
