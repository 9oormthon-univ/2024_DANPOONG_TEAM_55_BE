package goormthon.somtoring.domain.user.domain.user;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import goormthon.somtoring.common.auth.application.dto.AuthAttributes;
import goormthon.somtoring.common.domain.BaseTimeEntity;
import goormthon.somtoring.domain.user.domain.tag.UserTag;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

	private String nickname;

	@Enumerated(STRING)
	private LoginProvider loginProvider;

	private String externalId;

	@Enumerated(STRING)
	private Role role;

	private String university;

	private String additionalInfo;

	@OneToMany(mappedBy = "user", orphanRemoval = true)
	private List<UserTag> userTags = new ArrayList<>();

	public void selectRole(Role role) {
		this.role = role;
	}

	public void updateUniversity(String university) {
		this.university = university;
	}

	public void updateAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public void addUserTag(UserTag userTag) {
		userTags.add(userTag);
	}

	public void generateNickname(String nickname) {
		this.nickname = nickname;
	}

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
