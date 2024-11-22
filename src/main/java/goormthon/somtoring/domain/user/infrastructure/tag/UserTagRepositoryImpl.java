package goormthon.somtoring.domain.user.infrastructure.tag;

import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.user.domain.tag.UserTag;
import goormthon.somtoring.domain.user.domain.tag.UserTagRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserTagRepositoryImpl implements UserTagRepository {
	private final UserTagJpaRepository userTagJpaRepository;
	@Override
	public void save(UserTag userTag) {
		userTagJpaRepository.save(userTag);
	}
}
