package goormthon.somtoring.domain.match.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import goormthon.somtoring.domain.match.domain.Match;
import goormthon.somtoring.domain.match.domain.Status;

import java.util.List;

public interface MatchJpaRepository extends JpaRepository<Match, Long> {

    List<Match> findAllByMenteeIdAndStatus(Long menteeId, Status status);
}
