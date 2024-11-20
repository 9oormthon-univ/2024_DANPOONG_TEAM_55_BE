package goormthon.somtoring.domain.user.domain;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.util.Objects;

import goormthon.somtoring.common.auth.application.dto.AuthAttributes;
import goormthon.somtoring.common.domain.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@Table(name = "\"user\"")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class User extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String email;

	@Enumerated(STRING)
	private LoginProvider loginProvider;

	private String externalId;

	private User(String email, LoginProvider loginProvider, String externalId) {
		this.email = email;
		this.loginProvider = loginProvider;
		this.externalId = externalId;
	}

	public static User from(AuthAttributes authAttributes) {
		return new User(
			authAttributes.getEmail(),
			authAttributes.getProvider(),
			authAttributes.getExternalId()
		);
	}

	public boolean hasDifferentProviderWithEmail(String email, String externalId) {
		return Objects.equals(this.email, email) && !Objects.equals(this.externalId, externalId);
	}
}
