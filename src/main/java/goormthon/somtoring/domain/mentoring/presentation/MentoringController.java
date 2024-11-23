package goormthon.somtoring.domain.mentoring.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goormthon.somtoring.domain.mentoring.application.MentoringService;
import goormthon.somtoring.domain.mentoring.presentation.response.MentoringListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mentorings")
@Tag(name = "멘토링", description = "멘토링 관리 API")
public class MentoringController {
	private final MentoringService mentoringService;

	@Operation(summary = "홈화면 멘토링 최근 2개 조회", description = "홈화면 멘토링 최근 2개 조회")
	@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = MentoringListResponse.class)))
	@GetMapping("/home")
	public ResponseEntity<MentoringListResponse> getMentoringTwoList(){
		MentoringListResponse response = mentoringService.getMentoringTwoList();
		return ResponseEntity.ok(response);
	}
}
