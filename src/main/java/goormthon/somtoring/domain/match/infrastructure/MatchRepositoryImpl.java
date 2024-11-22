package goormthon.somtoring.domain.match.infrastructure;

import goormthon.somtoring.domain.match.domain.Match;
import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.match.domain.MatchRepository;
import lombok.RequiredArgsConstructor;

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
}
