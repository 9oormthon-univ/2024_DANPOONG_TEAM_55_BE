package goormthon.somtoring.domain.user.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import java.util.List;

import goormthon.somtoring.domain.user.domain.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserSummaryListResponse(
	@Schema(
		description = "유저 리스트",
		example = "[{\"id\": 1, \"nickname\": \"산뜻한 구름\", \"role\": \"MENTOR\", \"additionalInfo\": \"안녕하세요\", \"tags\": [\"열정적인\", \"친절한\"]}]",
		requiredMode = REQUIRED)
	List<UserSummaryResponse> contents
) {
	public static UserSummaryListResponse from(List<User> users) {
		return UserSummaryListResponse.builder()
			.contents(
				users.stream()
					.map(UserSummaryResponse::from)
					.toList()
			)
			.build();
	}
}
