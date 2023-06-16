package br.com.postech30.challenge.repository;

import br.com.postech30.challenge.entity.DependentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentRepository extends JpaRepository<DependentEntity, Long> {
    DependentEntity save(DependentEntity dependentEntity);

}