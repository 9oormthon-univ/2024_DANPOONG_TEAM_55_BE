package goormthon.somtoring.domain.user.application;

import java.util.List;

import org.springframework.stereotype.Service;

import goormthon.somtoring.domain.user.domain.tag.UserTag;
import goormthon.somtoring.domain.user.domain.tag.UserTagRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserTagService {
	private final UserTagRepository userTagRepository;

	public void saveUserTags(List<UserTag> userTagList) {
		userTagList.forEach(userTagRepository::save);
	}
}
