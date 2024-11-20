package goormthon.somtoring.common.auth.presentation.handler;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import goormthon.somtoring.common.auth.infrastructure.SecurityProperties;
import goormthon.somtoring.common.auth.presentation.exception.AuthExceptionCode;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private final SecurityProperties securityProperties;

	@Override
	public void onAuthenticationFailure(
		HttpServletRequest request, HttpServletResponse response, AuthenticationException exception
	) throws IOException, ServletException {
		super.setDefaultFailureUrl(securityProperties.loginUrl() + "?error=true&exception=" + AuthExceptionCode.AUTHENTICATION_REQUIRED);
		super.onAuthenticationFailure(request, response, exception);
	}
}

