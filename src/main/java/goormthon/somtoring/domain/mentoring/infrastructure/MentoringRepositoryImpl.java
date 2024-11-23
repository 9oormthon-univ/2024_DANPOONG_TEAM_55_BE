package goormthon.somtoring.domain.mentoring.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.mentoring.domain.Mentoring;
import goormthon.somtoring.domain.mentoring.domain.MentoringRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MentoringRepositoryImpl implements MentoringRepository {
	private final MentoringJpaRepository mentoringJpaRepository;

	@Override
	public List<Mentoring> findTop2ByOrderByCreatedAtDesc() {
		return mentoringJpaRepository.findTop2ByOrderByCreatedAtDesc();
	}
}
