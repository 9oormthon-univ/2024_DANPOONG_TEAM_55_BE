package goormthon.somtoring.common.auth.presentation.handler;

import static goormthon.somtoring.common.auth.presentation.exception.AuthExceptionCode.AUTHENTICATION_REQUIRED;
import static jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import goormthon.somtoring.common.exception.ExceptionResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private final ObjectMapper objectMapper;

	@Override
	public void commence(
		HttpServletRequest request, HttpServletResponse response, AuthenticationException exception
	) throws IOException {
		setResponseBodyBasicInfo(response);
		objectMapper.writeValue(response.getOutputStream(), ExceptionResponse.from(AUTHENTICATION_REQUIRED));
	}

	private void setResponseBodyBasicInfo(HttpServletResponse response) {
		response.setStatus(SC_UNAUTHORIZED);
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
	}
}

