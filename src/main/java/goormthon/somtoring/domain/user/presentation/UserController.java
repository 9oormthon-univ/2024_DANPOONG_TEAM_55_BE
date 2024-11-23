package goormthon.somtoring.domain.user.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import goormthon.somtoring.common.resolver.UserId;
import goormthon.somtoring.domain.user.application.UserService;
import goormthon.somtoring.domain.user.domain.user.Role;
import goormthon.somtoring.domain.user.presentation.request.UserAdditionalRequest;
import goormthon.somtoring.domain.user.presentation.response.UserDetailResponse;
import goormthon.somtoring.domain.user.presentation.response.UserNicknameResponse;
import goormthon.somtoring.domain.user.presentation.response.UserSummaryListResponse;
import goormthon.somtoring.domain.user.presentation.response.UserSummaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "유저", description = "유저 관리 api")
public class UserController {
	private final UserService userService;

	@Operation(summary = "유저 역할 선택", description = "MENTOR / MENTEE 중 한 가지 역할을 선택합니다.")
	@ApiResponse(responseCode = "200")
	@PatchMapping("/role")
	public ResponseEntity<Void> selectUserRole (
		@UserId Long userId,
		@RequestParam Role role
	) {
		userService.selectUserRole(userId, role);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "내 프로필 정보 조회", description = "내 프로필 기본 정보 및 varki 지수를 조회합니다.")
	@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = UserDetailResponse.class)))
	@GetMapping("/me")
	public ResponseEntity<UserDetailResponse> getUser(@UserId Long userId) {
		UserDetailResponse response = userService.getUser(userId);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = "프로필 정보 조회", description = "유저의 프로필 기본 정보 및 varki 지수를 조회합니다.")
	@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = UserDetailResponse.class)))
	@GetMapping("/{userId}")
	public ResponseEntity<UserDetailResponse> getUserById(@PathVariable Long userId) {
		UserDetailResponse response = userService.getUser(userId);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = "내 닉네임 조회", description = "회원가입 이후 내 닉네임을 조회합니다.")
	@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = UserNicknameResponse.class)))
	@GetMapping("/nickname")
	public ResponseEntity<UserNicknameResponse> getUserNickname(@UserId Long userId) {
		UserNicknameResponse nickname = userService.getUserNickname(userId);
		return ResponseEntity.ok(nickname);
	}

	@Operation(summary = "유저 추가 정보 입력", description = "유저 추가 정보를 입력합니다.")
	@ApiResponse(responseCode = "200")
	@PatchMapping
	public ResponseEntity<Void> updateUserAdditionalInfo(
		@UserId Long userId,
		@RequestBody UserAdditionalRequest request
	) {
		userService.updateUserAdditionalInfo(userId, request);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "내 VARKI 지수와 유사한 멘토 상위 5명 목록 조회", description = "내 VARKI 지수와 유사한 멘토 상위 5명의 목록을 조회합니다.")
	@ApiResponse(responseCode = "200")
	@GetMapping("/mentors")
	public ResponseEntity<UserSummaryListResponse> getMentors(@UserId Long userId) {
		UserSummaryListResponse response = userService.getMentors(userId);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = "내 VARKI 검사 내역 삭제", description = "내 VARKI 검사 내역을 삭제합니다.")
	@ApiResponse(responseCode = "204")
	@DeleteMapping
	public ResponseEntity<Void> deleteVarki(@UserId Long userId) {
		userService.deleteVarki(userId);
		return ResponseEntity.noContent().build();
	}

}
