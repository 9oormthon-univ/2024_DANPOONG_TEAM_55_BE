package goormthon.somtoring.domain.match.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import goormthon.somtoring.domain.match.domain.Match;

public interface MatchJpaRepository extends JpaRepository<Match, Long> {
}
