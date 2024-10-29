package msa.devmix.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import msa.devmix.config.oauth.userinfo.UserPrincipal;
import msa.devmix.dto.UserDto;
import msa.devmix.dto.response.ResponseDto;
import msa.devmix.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     * 로그인된 사용자 본인 정보 조회
     */
    @GetMapping
    public ResponseEntity<?> getSignInUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        log.info("UserDto: {}", UserDto.from(userPrincipal.getUser()).getUsername());
        return ResponseEntity.ok()
                .body(ResponseDto.success(UserDto.from(userPrincipal.getUser())));
    }

    /**
     * 사용자 상세 프로필 조회
     */
    @GetMapping("/{user-id}")
    public ResponseEntity<?> getUser(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok()
                .body(ResponseDto.success(userService.getUserInfo(userId)));
    }
}
