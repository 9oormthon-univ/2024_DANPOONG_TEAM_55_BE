package goormthon.somtoring.domain.user.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import java.util.List;

import goormthon.somtoring.domain.user.domain.tag.UserTag;
import goormthon.somtoring.domain.user.domain.user.Role;
import goormthon.somtoring.domain.user.domain.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserSummaryResponse(
	@Schema(description = "유저 id", example = "1", requiredMode = REQUIRED)
	Long id,

	@Schema(description = "유저 닉네임", example = "산뜻한 구름", requiredMode = REQUIRED)
	String nickname,

	@Schema(description = "유저 역할", example = "MENTOR", requiredMode = REQUIRED)
	Role role,

	@Schema(description = "유저 추가 정보", example = "안녕하세요", requiredMode = REQUIRED)
	String additionalInfo,

	@Schema(description = "유저 태그 리스트", example = "[\"열정적인\", \"친절한\"]", requiredMode = REQUIRED)
	List<String> tags
) {
	public static UserSummaryResponse from(User user) {
		return UserSummaryResponse.builder()
			.id(user.getId())
			.nickname(user.getNickname())
			.role(user.getRole())
			.additionalInfo(user.getAdditionalInfo())
			.tags(
				user.getUserTags().stream()
					.map(UserTag::getContent)
					.toList()
			)
			.build();
	}
}
