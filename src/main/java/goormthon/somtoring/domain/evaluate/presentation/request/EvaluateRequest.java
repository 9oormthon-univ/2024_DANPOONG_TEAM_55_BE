package goormthon.somtoring.domain.evaluate.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "멘토 평가 요청")
public record EvaluateRequest(
        @Schema(
                description = "태그 ID 리스트",
                example = "[1, 2, 8]",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        List<Long> tagIds
) {
}
