package goormthon.somtoring.domain.evaluate.presentation;

import goormthon.somtoring.domain.evaluate.application.EvaluateService;
import goormthon.somtoring.domain.evaluate.presentation.response.EvaluateSelectResponse;
import goormthon.somtoring.domain.user.presentation.response.UserDetailResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/evaluations")
@Tag(name = "평가", description = "멘토 평가 API")
public class EvaluateController {

    private final EvaluateService evaluateService;

    @Operation(summary = "멘토 평가 화면 조회", description = "멘티가 특정 멘토에 대한 평가 화면 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = EvaluateSelectResponse.class)))
    @GetMapping
    public ResponseEntity<EvaluateSelectResponse> getMentorForEvaluate(@RequestParam Long mentorId) {
        EvaluateSelectResponse response = evaluateService.getMentorForEvaluate(mentorId);
        return ResponseEntity.ok(response);
    }
}
