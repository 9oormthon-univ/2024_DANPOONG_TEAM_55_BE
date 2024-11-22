package goormthon.somtoring.common.config;

import static java.lang.String.format;
import static org.springframework.security.config.Elements.JWT;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

	private final Environment environment;

	private static final Map<String, String> PROFILE_SERVER_URL_MAP = Map.of(
		"local", "http://localhost:8080",
		"dev", "https://58.238.255.245:8080"
	);

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
			.info(apiInfo())
			.addSecurityItem(securityRequirement())
			.servers(initializeServers())
			.components(components());
	}

	private SecurityRequirement securityRequirement() {
		return new SecurityRequirement().addList(JWT);
	}

	private Info apiInfo() {
		return new Info()
			.title("SOMTORING API")
			.description(getDescription());
	}

	private List<Server> initializeServers() {
		return PROFILE_SERVER_URL_MAP.entrySet().stream()
			.filter(entry -> environment.matchesProfiles(entry.getKey()))
			.map(entry -> openApiServer(entry.getValue(), "SOMTORING API " + entry.getKey().toUpperCase()))
			.collect(Collectors.toList());
	}

	private Server openApiServer(String url, String description) {
		return new Server().url(url).description(description);
	}

	private Components components() {
		return new Components().addSecuritySchemes(JWT, securityScheme());
	}

	private SecurityScheme securityScheme() {
		return new SecurityScheme()
			.name(JWT)
			.type(SecurityScheme.Type.HTTP)
			.scheme("bearer")
			.bearerFormat(JWT);
	}

	private String getDescription() {
		return format("""
				멘토멘티 서비스, SOMTORING API 입니다.\n\n
				로그인 페이지에 접속 후, 카카오 로그인을 수행하세요.\n\n
				Local Login Page: <a href="%s" target="_blank">%s</a>\n\n
				쿠키에 액세스 토큰이 저장되며, 별다른 절차 없이 API를 사용하실 수 있습니다.\n\n
				""",
				getLoginUrlByProfile("local"), getLoginUrlByProfile("local"),
				getLoginUrlByProfile("dev"), getLoginUrlByProfile("dev")
			);
	}

	private String getLoginUrlByProfile(String profile) {
		return PROFILE_SERVER_URL_MAP.get(profile) + "/login";
	}
}