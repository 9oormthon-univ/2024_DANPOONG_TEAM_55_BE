package goormthon.somtoring.domain.match.presentation;

import goormthon.somtoring.domain.user.presentation.response.UserSummaryListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import goormthon.somtoring.common.resolver.UserId;
import goormthon.somtoring.domain.match.application.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/matches")
@Tag(name = "매칭", description = "매칭 관리 API")
public class MatchController {
	private final MatchService matchService;

	@Operation(summary = "멘토링 신청", description = "멘티가 추천 멘토 리스트에서 멘토링을 신청합니다.")
	@ApiResponse(responseCode = "204")
	@PostMapping
	public ResponseEntity<Void> applyMentoring(
		@UserId Long userId,
		@RequestParam Long mentorId
	) {
		matchService.applyMentoring(userId, mentorId);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "멘토링 승인", description = "멘토가 멘토링 신청을 승인합니다.")
	@ApiResponse(responseCode = "204")
	@PatchMapping("/{matchId}")
	public ResponseEntity<Void> approveMentoring(
		@UserId Long userId,
		@PathVariable Long matchId
	) {
		matchService.approveMentoring(userId, matchId);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "매칭된 멘토 리스트 조회", description = "멘티가 매칭된 멘토 리스트를 조회합니다.")
	@ApiResponse(responseCode = "200", description = "매칭된 멘토 리스트 반환")
	@GetMapping("/")
	public ResponseEntity<UserSummaryListResponse> getMatchedMentors(
			@UserId Long userId
	) {
		UserSummaryListResponse response = matchService.getMatchedMentors(userId);
		return ResponseEntity.ok(response);
	}
}
