package goormthon.somtoring.domain.question.presentation;

import goormthon.somtoring.domain.question.application.QuestionService;
import goormthon.somtoring.domain.question.presentation.response.QuestionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @Operation(summary = "VARKI 질문 저장", description = "")
    @ApiResponse(responseCode = "201", description = "성공")
    @PostMapping("/question")
    public ResponseEntity<Void> saveQuestion(@RequestBody QuestionResponse questionResponse) {
        questionService.save(questionResponse);
        return ResponseEntity.ok().build();
    }
}
