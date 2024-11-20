package goormthon.somtoring.common.auth.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import goormthon.somtoring.common.auth.domain.RefreshToken;

public interface RefreshTokenJpaRepository extends JpaRepository<RefreshToken, Long> {

	Optional<RefreshToken> findByToken(String token);

	Optional<RefreshToken> findFirstByUserIdOrderByIdDesc(Long id);
}
