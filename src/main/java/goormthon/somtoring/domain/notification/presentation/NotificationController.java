package goormthon.somtoring.domain.notification.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goormthon.somtoring.domain.notification.application.NotificationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notifications")
@Tag(name = "알림", description = "알림 관리 API")
public class NotificationController {
	private final NotificationService notificationService;


}
