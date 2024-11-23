package goormthon.somtoring.domain.match.infrastructure;

import goormthon.somtoring.domain.match.domain.Match;
import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.match.domain.MatchRepository;
import goormthon.somtoring.domain.match.domain.Status;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MatchRepositoryImpl implements MatchRepository {
	private final MatchJpaRepository matchJpaRepository;

	@Override
	public Match save(Match match) {
		return matchJpaRepository.save(match);
	}

	@Override
	public Optional<Match> findById(Long matchId) {
		return matchJpaRepository.findById(matchId);
	}

	@Override
	public List<Match> findAllByMenteeIdAndStatus(Long menteeId, Status status) {
		return matchJpaRepository.findAllByMenteeIdAndStatus(menteeId, status);
	}
}
