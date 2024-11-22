package goormthon.somtoring.domain.match.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import goormthon.somtoring.domain.match.domain.Match;

import java.util.List;

public interface MatchJpaRepository extends JpaRepository<Match, Long> {

    List<Match> findAllByMenteeIdAndIsAcceptedTrue(Long menteeId);
}
