package goormthon.somtoring.common.auth.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goormthon.somtoring.common.auth.application.dto.AuthAttributes;
import goormthon.somtoring.common.auth.domain.jwt.LoginResult;
import goormthon.somtoring.common.auth.domain.RefreshToken;
import goormthon.somtoring.common.auth.domain.RefreshTokenRepository;
import goormthon.somtoring.common.auth.domain.jwt.TokenGenerator;
import goormthon.somtoring.common.auth.infrastructure.jwt.TokenProperties;
import goormthon.somtoring.common.auth.presentation.exception.AlreadyRegisteredUserException;
import goormthon.somtoring.domain.user.domain.User;
import goormthon.somtoring.domain.user.domain.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final TokenGenerator tokenGenerator;
	private final RefreshTokenRepository refreshTokenRepository;
	private final TokenProperties tokenProperties;

	@Transactional
	public LoginResult handleLoginSuccess(AuthAttributes attributes) {
		String email = attributes.getEmail();

		return userRepository.findByEmail(email)
			.map(user -> handleExistUser(user, attributes))
			.orElseGet(() -> handleFirstLogin(attributes));
	}

	private LoginResult handleExistUser(User user, AuthAttributes attributes) {
		if (user.hasDifferentProviderWithEmail(attributes.getEmail(), attributes.getExternalId())) {
			throw new AlreadyRegisteredUserException();
		}

		return generateLoginResult(user, false);
	}

	private LoginResult handleFirstLogin(AuthAttributes attributes) {
		User newUser = saveNewUser(attributes);

		return generateLoginResult(newUser, true);
	}

	private LoginResult generateLoginResult(User user, boolean firstLogin) {
		String accessToken = tokenGenerator.generateAccessToken(user.getId());
		String refreshToken = tokenGenerator.generateRefreshToken(user.getId());

		RefreshToken refreshTokenEntity = refreshTokenRepository.findByUserId(user.getId())
			.orElse(RefreshToken.of(user.getId(), refreshToken, tokenProperties.expirationTime().refreshToken()));

		refreshTokenEntity.rotate(refreshToken);
		refreshTokenRepository.save(refreshTokenEntity);

		return new LoginResult(accessToken, refreshToken, firstLogin, user.getId());
	}

	private User saveNewUser(AuthAttributes attributes) {
		User user = User.from(attributes);
		return userRepository.save(user);
	}
}
