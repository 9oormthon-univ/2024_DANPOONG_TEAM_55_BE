package goormthon.somtoring.common.auth.domain;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import goormthon.somtoring.common.auth.application.dto.AuthAttributes;

import lombok.Getter;

@Getter
public class CustomOAuth2User extends DefaultOAuth2User {

	private final AuthAttributes authAttributes;

	public CustomOAuth2User(
		Collection<? extends GrantedAuthority> authorities,
		Map<String, Object> attributes,
		String nameAttributeKey,
		AuthAttributes authAttributes
	) {
		super(authorities, attributes, nameAttributeKey);
		this.authAttributes = authAttributes;
	}
}
