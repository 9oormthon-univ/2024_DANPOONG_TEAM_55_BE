package goormthon.somtoring.domain.notification.application;

import org.springframework.stereotype.Service;

import goormthon.somtoring.domain.notification.domain.Notification;
import goormthon.somtoring.domain.notification.domain.NotificationRepository;
import goormthon.somtoring.domain.notification.domain.Type;
import goormthon.somtoring.domain.user.domain.user.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {
	private final NotificationRepository notificationRepository;

	public void setNotification(String message, Type type, User user) {
		Notification notification = Notification.of(message, type, user);
		notificationRepository.save(notification);
	}
}
