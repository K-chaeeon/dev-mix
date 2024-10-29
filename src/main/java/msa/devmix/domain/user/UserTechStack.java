package msa.devmix.domain.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import msa.devmix.domain.common.Position;
import msa.devmix.domain.common.TechStack;


@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class UserTechStack {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_tech_stack_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tech_stack_id")
    private TechStack techStack;
}
