package msa.devmix.repository;

import msa.devmix.domain.user.User;
import msa.devmix.domain.user.UserTechStack;
import msa.devmix.dto.TechStackDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserTechStackRepository extends JpaRepository<UserTechStack, Long> {

    //N+1 문제 해결 X
    List<UserTechStack> findByUser(User user);

    //N+1 문제 해결 O
    @Query("SELECT new msa.devmix.dto.TechStackDto(ts.techStackName, ts.imageUrl)" +
            " FROM UserTechStack uts" +
            " JOIN uts.techStack ts" +
            " WHERE uts.user = :user")
    List<TechStackDto> findWithTechStackByUser(User user);
}
