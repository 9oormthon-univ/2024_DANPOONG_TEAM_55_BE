package goormthon.somtoring.domain.mentoring.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goormthon.somtoring.domain.mentoring.domain.Mentoring;
import goormthon.somtoring.domain.mentoring.domain.MentoringRepository;
import goormthon.somtoring.domain.mentoring.presentation.response.MentoringListResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MentoringService {
	private final MentoringRepository mentoringRepository;

	@Transactional(readOnly = true)
	public MentoringListResponse getMentoringTwoList() {
		List<Mentoring> mentorings = mentoringRepository.findTop2ByOrderByCreatedAtDesc();
		return MentoringListResponse.from(mentorings);
	}


}
