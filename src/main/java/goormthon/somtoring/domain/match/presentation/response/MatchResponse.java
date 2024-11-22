package goormthon.somtoring.domain.match.presentation.response;

import goormthon.somtoring.domain.match.domain.Match;

public record MatchResponse(Long mentorId, Long menteeId, boolean isAccepted) {

    public static MatchResponse of(Match match) {
        return new MatchResponse(
                match.getMentor().getId(),
                match.getMentee().getId(),
                match.isAccepted()
        );
    }
}
