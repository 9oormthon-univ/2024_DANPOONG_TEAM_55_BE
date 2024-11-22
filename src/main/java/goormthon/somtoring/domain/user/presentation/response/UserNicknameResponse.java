package goormthon.somtoring.domain.user.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import goormthon.somtoring.domain.user.domain.user.User;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserNicknameResponse(
	@Schema(description = "유저 닉네임", example = "산뜻한 구름", requiredMode = REQUIRED)
	String nickName
) {
	public static UserNicknameResponse from(User user) {
		return new UserNicknameResponse(user.getNickname());
	}
}
