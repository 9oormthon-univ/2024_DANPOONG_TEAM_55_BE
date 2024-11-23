package goormthon.somtoring.domain.notification.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import goormthon.somtoring.domain.notification.domain.Notification;

public interface NotificationJpaRepository extends JpaRepository<Notification, Long> {
}
