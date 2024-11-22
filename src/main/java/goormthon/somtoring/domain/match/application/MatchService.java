package goormthon.somtoring.domain.match.application;

import goormthon.somtoring.domain.match.domain.Match;
import goormthon.somtoring.domain.match.presentation.exception.AlreadyAcceptedMatchException;
import goormthon.somtoring.domain.match.presentation.exception.MatchNotFoundException;
import goormthon.somtoring.domain.match.presentation.exception.MenteeNotFoundException;
import goormthon.somtoring.domain.match.presentation.exception.MentorNotFoundException;
import goormthon.somtoring.domain.match.presentation.requeset.MatchRequest;
import goormthon.somtoring.domain.match.presentation.response.MatchResponse;
import goormthon.somtoring.domain.user.application.UserService;
import goormthon.somtoring.domain.user.domain.user.Role;
import goormthon.somtoring.domain.user.domain.user.User;
import goormthon.somtoring.domain.user.domain.user.UserRepository;
import org.springframework.stereotype.Service;

import goormthon.somtoring.domain.match.domain.MatchRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
	private final MatchRepository matchRepository;
	private final UserService userService;
	private final UserRepository userRepository;

	public void applyMentoring(Long menteeId, Long mentorId) {

		User mentor = userRepository.findByIdAndRole(mentorId, Role.MENTOR)
				.orElseThrow(MentorNotFoundException::new);

		User mentee = userService.getByUserId(menteeId);

		Match match = Match.of(mentor, mentee);
		matchRepository.save(match);
	}

	public MatchResponse approveMentoring(Long matchId) {
		Match match = matchRepository.findById(matchId)
				.orElseThrow(MatchNotFoundException::new);

		if (match.isAccepted()) {
			throw new AlreadyAcceptedMatchException();
		}

		match.accept();
		matchRepository.save(match);

		return MatchResponse.of(match);
	}
}
