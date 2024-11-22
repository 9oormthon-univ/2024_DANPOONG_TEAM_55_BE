package goormthon.somtoring.domain.match.application;

import org.springframework.stereotype.Service;

import goormthon.somtoring.domain.match.domain.MatchRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatchService {
	private final MatchRepository matchRepository;
}
