package msa.devmix.service;

import msa.devmix.domain.user.User;
import msa.devmix.dto.UserWithPositionTechStackDto;

public interface UserService {
    User findById(Long userId);
    User findByUsername(String username);
    UserWithPositionTechStackDto getUserInfo(Long userId);
}
