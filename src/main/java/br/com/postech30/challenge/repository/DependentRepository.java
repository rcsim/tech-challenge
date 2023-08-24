package br.com.postech30.challenge.repository;

import br.com.postech30.challenge.entity.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Long> {

    List<Dependent> findByNameIgnoreCaseContainingOrDateOfBirthIgnoreCaseContainingOrGenderIgnoreCaseContainingOrParentageIgnoreCaseContaining(String name, String dateOfBirth, String gender, String parentage);

}