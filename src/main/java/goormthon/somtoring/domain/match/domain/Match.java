package goormthon.somtoring.domain.match.domain;

import goormthon.somtoring.common.domain.BaseTimeEntity;
import goormthon.somtoring.domain.match.presentation.exception.AlreadyAcceptedMatchException;
import goormthon.somtoring.domain.user.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@Table(name = "\"match\"")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Match extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mentor_id")
	private User mentor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mentee_id")
	private User mentee;

	private boolean isAccepted;

	public static Match of(User mentor, User mentee) {
		return Match.builder()
			.mentor(mentor)
			.mentee(mentee)
			.isAccepted(false)
			.build();
	}

	public void accept() {
		if(this.isAccepted) throw new AlreadyAcceptedMatchException();
		this.isAccepted = true;
	}

	public boolean isMentor(User user) {
		return this.mentor.equals(user);
	}
}
