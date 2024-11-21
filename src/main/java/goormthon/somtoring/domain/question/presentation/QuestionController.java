package goormthon.somtoring.domain.question.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import goormthon.somtoring.common.resolver.UserId;
import goormthon.somtoring.domain.question.application.QuestionService;
import goormthon.somtoring.domain.question.presentation.response.QuestionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/questions")
@Tag(name = "질문", description = "질문 관리 api")
public class QuestionController {
	private final QuestionService questionService;

	@Operation(summary = "VARKI 검사 다음 질문 조회", description = "VARKI 검사 질문 중 유저가 답변하지 않은 다음 질문을 조회합니다.")
	@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = QuestionResponse.class)))
	@GetMapping("/next")
	public ResponseEntity<QuestionResponse> getNextQuestion(@UserId Long userId) {
		QuestionResponse response = questionService.getNextQuestion(userId);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = "VARKI 검사 단건 질문 답변", description = "VARKI 검사 단건 질문에 답변합니다.")
	@ApiResponse(responseCode = "204")
	@PostMapping("/{questionId}")
	public ResponseEntity<Void> answerQuestion(
		@UserId Long userId,
		@PathVariable Long questionId,
		@RequestParam Long answerId
	) {
		questionService.answerQuestion(userId, questionId, answerId);
		return ResponseEntity.noContent().build();
	}

}
