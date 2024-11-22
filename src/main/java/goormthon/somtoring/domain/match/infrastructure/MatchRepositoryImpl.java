package goormthon.somtoring.domain.match.infrastructure;

import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.match.domain.MatchRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MatchRepositoryImpl implements MatchRepository {
	private final MatchJpaRepository matchJpaRepository;
}
