package goormthon.somtoring.domain.user.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import java.util.List;

import goormthon.somtoring.domain.user.domain.user.Role;
import goormthon.somtoring.domain.user.domain.user.User;
import goormthon.somtoring.domain.user.domain.tag.UserTag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserDetailResponse(
	@Schema(description = "유저 id", example = "1", requiredMode = REQUIRED)
	Long id,

	@Schema(description = "유저 닉네임", example = "산뜻한 구름", requiredMode = REQUIRED)
	String nickname,

	@Schema(description = "유저 역할", example = "MENTOR", requiredMode = REQUIRED)
	Role role,

	@Schema(description = "유저 대학교", example = "고려대학교", requiredMode = REQUIRED)
	String university,

	@Schema(description = "유저 추가 정보", example = "안녕하세요", requiredMode = REQUIRED)
	String additionalInfo,

	@Schema(description = "유저 태그 리스트", example = "[\"열정적인\", \"친절한\"]", requiredMode = REQUIRED)
	List<String> tags,

	@Schema(description = "유저 당도", example = "50", requiredMode = REQUIRED)
	int sugar,

	@Schema(
		description = "유저 varki 지수",
		example = "{\"v\": 10, \"a\": 20, \"r\": 30, \"k\": 10, \"i\": 20}",
		requiredMode = REQUIRED)
	VarkiResponse varki
) {
	public static UserDetailResponse from(User user) {
		return UserDetailResponse.builder()
			.id(user.getId())
			.nickname(user.getNickname())
			.role(user.getRole())
			.university(user.getUniversity())
			.additionalInfo(user.getAdditionalInfo())
			.tags(
				user.getUserTags().stream()
					.map(UserTag::getContent)
					.toList()
			)
			.sugar(user.getSugar())
			.varki(VarkiResponse.from(user.getVarki()))
			.build();
	}
}
