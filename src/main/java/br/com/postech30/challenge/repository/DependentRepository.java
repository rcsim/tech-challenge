package br.com.postech30.challenge.repository;

import br.com.postech30.challenge.entity.Dependent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Long> {

    Page<Dependent> findByNameIgnoreCaseContainingOrDateOfBirthIgnoreCaseContainingOrGenderIgnoreCaseContainingOrParentageIgnoreCaseContaining(String name, String dateOfBirth, String gender, String parentage, Pageable pageable);

    List<Dependent> findByAddress_Id(Long id);

    List<Dependent> findByApplianceSet_Id(Long id);
}