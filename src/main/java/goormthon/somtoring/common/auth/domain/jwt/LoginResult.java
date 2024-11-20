package goormthon.somtoring.common.auth.domain.jwt;

public record LoginResult(
	String accessToken,
	String refreshToken,
	boolean isNewUser,
	Long userId
) {
}
