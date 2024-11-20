package goormthon.somtoring.common.auth.application.dto;

import java.util.Map;

import goormthon.somtoring.domain.user.domain.LoginProvider;

public interface AuthAttributes {

	String getExternalId();

	String getEmail();

	LoginProvider getProvider();

	static AuthAttributes of(String providerId, Map<String, Object> attributes) {
		if (LoginProvider.kakao.isProviderOf(providerId)) {
			return KakaoAuthAttributes.of(attributes);
		}
		throw new IllegalArgumentException("Unsupported id: " + providerId);
	}
}
