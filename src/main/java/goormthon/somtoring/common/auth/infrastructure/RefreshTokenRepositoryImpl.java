package goormthon.somtoring.common.auth.infrastructure;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import goormthon.somtoring.common.auth.domain.RefreshToken;
import goormthon.somtoring.common.auth.domain.RefreshTokenRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class RefreshTokenRepositoryImpl implements RefreshTokenRepository {

	private final RefreshTokenJpaRepository refreshTokenJpaRepository;

	@Override
	public Optional<RefreshToken> findByToken(String token) {
		return refreshTokenJpaRepository.findByToken(token);
	}

	@Override
	public Optional<RefreshToken> findByUserId(Long id) {
		return refreshTokenJpaRepository.findFirstByUserIdOrderByIdDesc(id);
	}

	@Override
	public void save(RefreshToken refreshToken) {
		refreshTokenJpaRepository.save(refreshToken);
	}
}
