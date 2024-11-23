package goormthon.somtoring.domain.match.application;

import goormthon.somtoring.domain.match.domain.Status;
import goormthon.somtoring.domain.user.presentation.response.UserSummaryListResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goormthon.somtoring.domain.match.domain.Match;
import goormthon.somtoring.domain.match.domain.MatchRepository;
import goormthon.somtoring.domain.match.presentation.exception.ApproveUnauthorizedMentorException;
import goormthon.somtoring.domain.match.presentation.exception.MatchNotFoundException;
import goormthon.somtoring.domain.user.application.UserService;
import goormthon.somtoring.domain.user.domain.user.Role;
import goormthon.somtoring.domain.user.domain.user.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
	private final MatchRepository matchRepository;
	private final UserService userService;

	public void applyMentoring(Long userId, Long mentorId) {
		User mentee = userService.getByUserIdAndRole(userId, Role.MENTEE);
		User mentor = userService.getByUserIdAndRole(mentorId, Role.MENTOR);
		Match match = Match.of(mentor, mentee);
		matchRepository.save(match);
	}

	@Transactional
	public void approveMentoring(Long userId, Long matchId) {
		validateMentor(userId, matchId);
		Match match = getMatchById(matchId);
		match.accept();
	}

	private void validateMentor(Long userId, Long matchId) {
		User user = userService.getByUserId(userId);
		Match match = getMatchById(matchId);
		if (!match.isMentor(user)) throw new ApproveUnauthorizedMentorException();
	}

	private Match getMatchById(Long matchId) {
		return matchRepository.findById(matchId)
			.orElseThrow(MatchNotFoundException::new);
	}

	@Transactional(readOnly = true)
	public UserSummaryListResponse getMatchedMentors(Long menteeId) {
		List<Match> matches = matchRepository.findAllByMenteeIdAndStatus(menteeId, Status.ACCEPTED);
		List<User> mentors = matches.stream()
				.map(Match::getMentor)
				.toList();
		return UserSummaryListResponse.from(mentors);
	}
}
