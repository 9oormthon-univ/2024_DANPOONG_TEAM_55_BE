package goormthon.somtoring.domain.notification.infrastructure;

import org.springframework.stereotype.Repository;

import goormthon.somtoring.domain.notification.domain.Notification;
import goormthon.somtoring.domain.notification.domain.NotificationRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepository {
	private final NotificationJpaRepository notificationJpaRepository;

	@Override
	public void save(Notification notification) {
		notificationJpaRepository.save(notification);
	}
}
