package goormthon.somtoring.domain.match.domain;

import java.util.List;
import java.util.Optional;

public interface MatchRepository {

    Match save(Match match);

    Optional<Match> findById(Long matchId);

    List<Match> findAllByMenteeIdAndStatus(Long menteeId, Status status);
}
