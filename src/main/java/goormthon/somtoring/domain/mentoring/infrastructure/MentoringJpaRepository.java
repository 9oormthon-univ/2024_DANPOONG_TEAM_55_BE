package goormthon.somtoring.domain.mentoring.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import goormthon.somtoring.domain.mentoring.domain.Mentoring;

public interface MentoringJpaRepository extends JpaRepository<Mentoring, Long>{
	List<Mentoring> findTop2ByOrderByCreatedAtDesc();
}
