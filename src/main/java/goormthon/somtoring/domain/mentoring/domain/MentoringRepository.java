package goormthon.somtoring.domain.mentoring.domain;

import java.util.List;

public interface MentoringRepository {
	List<Mentoring> findTop2ByOrderByCreatedAtDesc();
}
