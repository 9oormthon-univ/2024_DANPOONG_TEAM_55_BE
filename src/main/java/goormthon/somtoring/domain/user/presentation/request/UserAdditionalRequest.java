package goormthon.somtoring.domain.user.presentation.request;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserAdditionalRequest(
	@Schema(description = "캠퍼스 이름", example = "구름대 서울캠", requiredMode = NOT_REQUIRED)
	String university,

	@Schema(description = "추가 정보", example = "23학번, 재학생", requiredMode = NOT_REQUIRED)
	String additionalInfo,

	@Schema(description = "태그 리스트", example = "[\"열정적인\", \"친절한\"]", requiredMode = NOT_REQUIRED)
	List<String> tags
) {
}
