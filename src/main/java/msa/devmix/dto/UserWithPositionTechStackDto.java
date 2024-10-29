package msa.devmix.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import msa.devmix.domain.user.User;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserWithPositionTechStackDto {

    private String nickname;
    private String profileImage;
    private String groupName;
//    private String location;
    private String email;

    private List<String> positionNames;
    private List<TechStackDto> techStackNames;

    public static UserWithPositionTechStackDto of(User user, List<String> positionNames, List<TechStackDto> techStackNames) {
        return new UserWithPositionTechStackDto(
                user.getNickname(),
                user.getProfileImage(),
                user.getGroupName(),
                user.getEmail(),
                positionNames,
                techStackNames
        );
    }
}
