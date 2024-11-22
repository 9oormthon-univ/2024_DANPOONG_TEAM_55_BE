package goormthon.somtoring.domain.user.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import goormthon.somtoring.domain.user.domain.user.Role;
import goormthon.somtoring.domain.user.domain.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserDetailResponse(
	@Schema(description = "유저 id", example = "1", requiredMode = REQUIRED)
	Long id,

	@Schema(description = "유저 이메일", example = "example@gmail.com", requiredMode = REQUIRED)
	String email,

	@Schema(description = "유저 닉네임", example = "산뜻한 구름", requiredMode = REQUIRED)
	String nickname,

	@Schema(description = "유저 역할", example = "MENTOR", requiredMode = REQUIRED)
	Role role
) {
	public static UserDetailResponse from(User user) {
		return UserDetailResponse.builder()
			.id(user.getId())
			.email(user.getEmail())
			.nickname(user.getNickname())
			.role(user.getRole())
			.build();
	}
}
