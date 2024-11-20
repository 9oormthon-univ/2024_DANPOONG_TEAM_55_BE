package goormthon.somtoring.common.auth.domain.jwt;

public interface TokenGenerator {

	String generateAccessToken(Long userId);

	String generateRefreshToken(Long userId);
}
