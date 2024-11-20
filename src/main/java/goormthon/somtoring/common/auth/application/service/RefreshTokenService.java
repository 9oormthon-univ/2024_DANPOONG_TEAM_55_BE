package goormthon.somtoring.common.auth.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goormthon.somtoring.common.auth.application.jwt.TokenInjector;
import goormthon.somtoring.common.auth.domain.jwt.LoginResult;
import goormthon.somtoring.common.auth.domain.RefreshToken;
import goormthon.somtoring.common.auth.domain.RefreshTokenRepository;
import goormthon.somtoring.common.auth.domain.jwt.TokenGenerator;
import goormthon.somtoring.common.auth.domain.jwt.TokenResolver;
import goormthon.somtoring.common.auth.infrastructure.jwt.TokenProperties;
import goormthon.somtoring.common.auth.presentation.exception.AuthenticationRequiredException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class RefreshTokenService {

	private final RefreshTokenRepository refreshTokenRepository;
	private final TokenGenerator tokenGenerator;
	private final TokenResolver tokenResolver;
	private final TokenInjector tokenInjector;
	private final TokenProperties tokenProperties;

	@Transactional
	public LoginResult reissueBasedOnRefreshToken(HttpServletRequest request, HttpServletResponse response) {
		String refreshToken = tokenResolver.resolveRefreshTokenFromRequest(request)
			.orElseThrow(AuthenticationRequiredException::new);

		RefreshToken savedRefreshToken = validateAndGetSavedRefreshToken(refreshToken);

		return getReissuedTokenResult(response, savedRefreshToken);
	}

	private LoginResult getReissuedTokenResult(HttpServletResponse response, RefreshToken savedRefreshToken) {
		Long userId = savedRefreshToken.getUserId();

		String reissuedAccessToken = tokenGenerator.generateAccessToken(userId);
		String rotatedRefreshToken = this.rotate(savedRefreshToken);

		LoginResult loginResult = new LoginResult(
			reissuedAccessToken, rotatedRefreshToken, false, userId);
		tokenInjector.injectTokensToCookie(loginResult, response);

		return loginResult;
	}

	private RefreshToken validateAndGetSavedRefreshToken(String refreshToken) {
		Long userId = Long.valueOf(tokenResolver.getSubjectFromToken(refreshToken));
		RefreshToken savedRefreshToken = this.getByTokenString(refreshToken);

		savedRefreshToken.validateWith(refreshToken, userId);

		return savedRefreshToken;
	}

	public RefreshToken getByTokenString(String token) {
		return refreshTokenRepository.findByToken(token)
			.orElseThrow(AuthenticationRequiredException::new);
	}

	private String rotate(RefreshToken refreshToken) {
		String reissuedToken = tokenGenerator.generateRefreshToken(refreshToken.getUserId());
		refreshToken.rotate(reissuedToken);
		refreshToken.updateExpirationIfExpired(tokenProperties.expirationTime().refreshToken());
		refreshTokenRepository.save(refreshToken);

		return reissuedToken;
	}
}

