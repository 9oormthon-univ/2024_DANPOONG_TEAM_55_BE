package goormthon.somtoring.domain.evaluate.presentation;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import goormthon.somtoring.common.resolver.UserId;
import goormthon.somtoring.domain.evaluate.application.EvaluateService;
import goormthon.somtoring.domain.evaluate.presentation.request.EvaluateRequest;
import goormthon.somtoring.domain.evaluate.presentation.response.EvaluateSelectResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

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

    @Operation(summary = "멘토 평가 저장", description = "멘티가 특정 멘토에 대한 평가를 저장합니다.")
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = EvaluateRequest.class)))
    @PostMapping("/create")
    public ResponseEntity<Void> evaluateMentor(
        @UserId Long userId,
        @RequestParam Long mentorId,
        @RequestBody EvaluateRequest evaluateRequest
    ) {
        evaluateService.evaluateMentor(userId, mentorId, evaluateRequest);
        return ResponseEntity.status(CREATED).build();
    }
}
