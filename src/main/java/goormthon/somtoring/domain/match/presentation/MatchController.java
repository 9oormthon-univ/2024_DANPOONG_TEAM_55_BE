package goormthon.somtoring.domain.match.presentation;

import goormthon.somtoring.common.resolver.UserId;
import goormthon.somtoring.domain.user.application.UserService;
import goormthon.somtoring.domain.user.presentation.response.UserDetailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import goormthon.somtoring.domain.match.application.MatchService;
import goormthon.somtoring.domain.match.presentation.response.MatchResponse;
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
	private final UserService userService;

	@Operation(summary = "멘토링 신청", description = "멘토와 멘티의 정보를 바탕으로 멘토링 신청을 처리합니다.")
	@ApiResponse(responseCode = "200", description = "멘토링 신청 완료")
	@PostMapping("/apply")
	public ResponseEntity<String> applyMentoring(@UserId Long userId, @RequestParam Long mentorId) {
		UserDetailResponse response = userService.getUserMe(userId);
		matchService.applyMentoring(userId, mentorId);
		return ResponseEntity.ok("멘토링 신청이 완료되었습니다.");
	}

	@Operation(summary = "멘토링 승인", description = "매칭된 멘토링을 승인합니다.")
	@ApiResponse(responseCode = "200", description = "멘토링 승인 완료")
	@PostMapping("/approve/{matchId}")
	public ResponseEntity<MatchResponse> approveMentoring(@PathVariable Long matchId) {
		MatchResponse responseDto = matchService.approveMentoring(matchId);
		return ResponseEntity.ok(responseDto);
	}
}
