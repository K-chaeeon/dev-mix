package msa.devmix.repository;

import msa.devmix.domain.common.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechStackRepository extends JpaRepository<TechStack, Long> {
    TechStack findByTechStackName(String techStackName);
}
