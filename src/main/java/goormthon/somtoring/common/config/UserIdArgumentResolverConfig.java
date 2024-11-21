package goormthon.somtoring.common.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import goormthon.somtoring.common.resolver.UserIdArgumentResolver;

@Configuration
public class UserIdArgumentResolverConfig implements WebMvcConfigurer {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new UserIdArgumentResolver());
	}
}

