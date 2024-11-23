package goormthon.somtoring.domain.notification.domain;

import static jakarta.persistence.FetchType.LAZY;

import goormthon.somtoring.domain.user.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String message;

	@Enumerated(EnumType.STRING)
	private Type type;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "target_id")
	private User target;

	public static Notification of(String message, Type type, User target) {
		return Notification.builder()
			.message(message)
			.type(type)
			.target(target)
			.build();
	}
}
