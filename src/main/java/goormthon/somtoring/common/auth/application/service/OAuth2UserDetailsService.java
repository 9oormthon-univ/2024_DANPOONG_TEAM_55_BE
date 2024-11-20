package goormthon.somtoring.common.auth.application.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import goormthon.somtoring.common.auth.domain.CustomUserDetails;
import goormthon.somtoring.domain.user.domain.User;
import goormthon.somtoring.domain.user.domain.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OAuth2UserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Long userId = Long.valueOf(username);
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + userId));

		return new CustomUserDetails(user.getId());
	}
}
