package msa.devmix.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import msa.devmix.domain.constant.Location;
import msa.devmix.domain.constant.Role;
import msa.devmix.domain.user.User;

@Getter @Setter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String username; //로그인 ID
    private String nickname; //닉네임
    private String email; //이메일
    private String groupName; //소속  e.g.,학교, 회사 등
    private String profileImage; //프로필 이미지
    private Role role;

    public static UserDto from(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getNickname(),
                user.getEmail(),
                user.getGroupName(),
                user.getProfileImage(),
                user.getRole()
        );
    }

    public static UserDto of(Long id, String username, String nickname, String email, String groupName, String profileImage, Role role) {
        return new UserDto(id, username, nickname, email, groupName, profileImage, role);
    }
}
