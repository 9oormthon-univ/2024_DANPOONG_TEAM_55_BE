package goormthon.somtoring.common.auth.infrastructure.jwt;

import static io.jsonwebtoken.io.Decoders.BASE64;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import goormthon.somtoring.common.auth.domain.jwt.TokenGenerator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtTokenGenerator implements TokenGenerator {

	private final TokenProperties tokenProperties;

	@Override
	public String generateAccessToken(Long userId) {
		long currentTimeMillis = System.currentTimeMillis();
		Date now = new Date(currentTimeMillis);
		Date expiration = new Date(currentTimeMillis + tokenProperties.expirationTime().accessToken() * 1000);
		SecretKey secretKey = Keys.hmacShaKeyFor(BASE64.decode(tokenProperties.secretKey()));

		return Jwts.builder()
			.subject(String.valueOf(userId))
			.issuedAt(now)
			.expiration(expiration)
			.signWith(secretKey)
			.compact();
	}

	@Override
	public String generateRefreshToken(Long userId) {
		long currentTimeMillis = System.currentTimeMillis();
		Date now = new Date(currentTimeMillis);
		SecretKey secretKey = Keys.hmacShaKeyFor(BASE64.decode(tokenProperties.secretKey()));

		return Jwts.builder()
			.subject(String.valueOf(userId))
			.issuedAt(now)
			.signWith(secretKey)
			.compact();
	}
}
