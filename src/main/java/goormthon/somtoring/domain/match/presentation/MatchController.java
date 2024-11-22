package goormthon.somtoring.domain.match.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goormthon.somtoring.domain.match.application.MatchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/matches")
@Tag(name = "매칭", description = "매칭 관리 api")
public class MatchController {
	private final MatchService matchService;
}
